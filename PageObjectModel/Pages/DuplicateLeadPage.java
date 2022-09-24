package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods {

	public DuplicateLeadPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	public DuplicateLeadPage clearAndEnterCompanyname(String dcname) {
		WebElement eleCompany1 = driver.findElement(By.id("createLeadForm_companyName"));
		eleCompany1.clear();
		eleCompany1.sendKeys(dcname);
		return this;
	}
	
	public DuplicateLeadPage clearAndEnterFirstname(String dfname) {
		WebElement eleFirst1 = driver.findElement(By.id("createLeadForm_firstName"));
		eleFirst1.clear();
		eleFirst1.sendKeys(dfname);
		return this;
	}
	
	public ViewLeadPage clickCreateLead() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage(driver);
	}
	
}
