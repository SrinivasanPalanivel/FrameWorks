package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import baseClass.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{
	
	public CreateLeadPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	
	public CreateLeadPage enterCompanyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		return this;	
	}
	
	public CreateLeadPage enterLastName(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		return this;
	}
	
	public CreateLeadPage enterDeptName(String dname) {
		driver.findElement(By.name("departmentName")).sendKeys(dname);
		return this;
	}
	
	public CreateLeadPage enterDiscription(String role) {
		driver.findElement(By.id("createLeadForm_description")).sendKeys(role);
		return this;
	}
	
	public CreateLeadPage enterEmail(String email) {
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		return this;
	}
	
	public CreateLeadPage enterState(String state) {
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select dd1 = new Select(eleState);
		dd1.selectByVisibleText(state);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewLeadPage(driver);
	}

}
