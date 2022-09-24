package marathon_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class EditIncident extends ServiceNowMethods {
	
	@Test(priority = 2)
	public void testEditIncident() {
	
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		
		//3. Click All
		shadow.findElementByXPath("//div[text()='All']").click();
		
		//4.Click  Incidents in Filter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		
		//4. Search for the existing incident and click on the incident
		driver.findElement(By.xpath("//th[@name='number']/following::tbody/tr/td[3]/a")).click();
		
		//5. Update the incident with Urgency as High and State as In Progress
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select dd = new Select(urgency);
		dd.selectByVisibleText("1 - High");
		
		WebElement state = driver.findElement(By.id("incident.state"));
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("On Hold");

		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("Edited Via Automation");
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
		
		//6. Verify the update information is available in the incident
		
	}
}