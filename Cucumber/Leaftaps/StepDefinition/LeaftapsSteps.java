package stepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaftapsSteps {
	
	public EdgeDriver driver;
	public String leadID;
	
	@Given("Edge Browser is Opened")
	public void openBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	@And("Switch bt Window")
	public void switch_window() {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList <String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
	}
	@And("Load the Application URL")
	public void loadURL() {
		driver.get("http://leaftaps.com/opentaps");
	}
	@And("Maximize the window and Set the Timeouts")
	public void maximizeAndtimeout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@And("Provide the valid Login Credentials")
	public void login() {
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@And("Click the CRMSFA")
	public void crmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@And("Click the Leads")
	public void lead() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click the Create Lead")
	public void createLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@And("Enter the Company {string}")
	public void companyname(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}
	@And("Enter the Firstname {string}")
	public void forename(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}
	@And("Enter the lastname {string}")
	public void surname(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}
	@When("Create Lead is Clicked")
	public void clicklead() {
		driver.findElement(By.className("smallSubmit")).click();
	}
	@Then("View Lead Should be Displayed")
	public void verifyViewLead() {
		String title = driver.getTitle();
		
		if(title.contains("View"))
			System.out.println("Title Verified...");
		else
			System.out.println("Title Not Verified...");
	}
	
	//Testcase002 - Edit Lead
	
	@And("Click the Find Leads")
	public void findLead() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@And("Enter {string}")
	public void firstName(String fname) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fname);
	}
	@And("Click Find Lead button")
	public void findLead_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	@And("Click on the first result")
	public void first_result() {
		driver.findElement(By.xpath("(//a[text()='Srini'])[1]")).click();
	}
	@And("Verify title")
	public void verifyTitle() {
		String actual_title = driver.getTitle();
		String expected_title = "View Lead | opentaps CRM";
		
		if(actual_title.equals(expected_title))
		{
			System.out.println("Title Verifed Sucessfully!!!");
		}
		else
		{
			System.out.println("Title Not Verifed Sucessfully!!!");
		}
	}
	@And("Click Edit")
	public void edit() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	@And("Change {string}")
	public void company(String cname) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
	}
	@When("Click Update Button")
	public void update() {
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
	}
	@And("Confirm name change")
	public void nameChange() {
		String com_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(com_name.contains("Nightmare"))
		{
			System.out.println("Confirmed!!!");
		}
		else
		{
			System.out.println("Not Confirmed!!!");
		}
	}
	
	// Testcase003 - deleteLead
	
	@And("Click Phone")
	public void phone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("Enter Phone Number {string}")
	public void number(String phone) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
	}
	@And("Capture the Lead ID")
	public void leadID() {
		leadID = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
	}
	@And("Click on the First ID")
	public void firstID() {
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	}
	@And("Click Delete Button")
	public void delete() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}
	@And("Enter Captured Lead ID")
	public void enterID() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	@And("Verify Message")
	public void msg() {
		String delete = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String delete1 = "No records to display";
		
		if(delete.equals(delete1))
		{
			System.out.println("Deletion Verifed SucessFully!!!");
		}
		else
		{
			System.out.println("Deletion Verifed Not SucessFully!!!");
		}
	}
	
	@Then("Close Browser")
	public void closeBrowser() {
		driver.quit();
	}

}
