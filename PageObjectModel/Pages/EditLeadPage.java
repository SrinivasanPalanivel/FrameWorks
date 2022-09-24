package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{
	
	public EditLeadPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	public EditLeadPage clearAndEnterCompanyName(String company) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		return this;
	}
	
	public ViewLeadPage clickUpdate() {
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		return new ViewLeadPage(driver);
	}

}
