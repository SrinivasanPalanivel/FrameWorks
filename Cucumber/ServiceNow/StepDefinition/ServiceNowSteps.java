package stepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowSteps {
	
	public EdgeDriver driver;
	public Shadow shadow;
	public String text2;
	
	@Given("Edgebrowser Opened")
	public void openBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	@And("Switch Window")
	public void switch_window() {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList <String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
	}
	
	@And("Load Application URL")
	public void loadURL() {
		driver.get("https://dev135016.service-now.com");
	}
	@And("Maximize window and Set Timeouts")
	public void maxiAndtimeout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@And("Provide Login Credentials")
	public void login() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		driver.findElement(By.id("sysverb_login")).click();
	}	
	
	@And("Click All")
	public void all() {
		shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
	}
	@And("Click Incidents in Filter navigator")
	public void incident() {
		shadow.findElementByXPath("//span[text()='Incidents']").click();
	}
	@And("Click on Create new option")
	public void new_incident() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
	}
	@And("Fill the mandatory fields")
	public void fields() {
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Inident NUmber : "+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
	}
	@When("Clicked in Submit")
	public void submit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
	}

	// Test Case2
	@And("Click on the Incident")
	public void click_incident() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//th[@name='number']/following::tbody/tr/td[3]/a")).click();
	}
	
	@And("Change the Urgency")
	public void urgency() {
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select dd = new Select(urgency);
		dd.selectByVisibleText("1 - High");

	}
	
	@And("Change the State")
	public void state() {
		WebElement state = driver.findElement(By.id("incident.state"));
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("On Hold");
	}
	
	@And("Change the Discription")
	public void discription() {
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("Edited Via Automation");
	}
	@And("Click Update")
	public void update() {
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
	}
	
	@And("Click Delete")
	public void delete() {
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
	}
	
	@Then("Close the Browser")
	public void close() {
		driver.quit();
	}


}
