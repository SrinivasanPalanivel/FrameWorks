package marathon_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.github.sukgu.Shadow;

public class DeleteIncident extends ServiceNowMethods {

	@Test(priority = 3)
	public void testDeleteIncident() {

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		
		//3. Click All
	    shadow.findElementByXPath("//div[text()='All']").click();
	    
	    //4.Click  Incidents in Filter navigator
	   	shadow.findElementByXPath("//span[text()='Incidents']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//th[@name='number']/following::tbody/tr/td[3]/a")).click();
		
		//5. Delete the incident
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		
		//6. Verify the deleted incident

	}

}
