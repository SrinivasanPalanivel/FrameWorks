package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods{
	
	public FindLeadPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	public FindLeadPage enterFirstname(String find) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(find);
		return this;
	}
	
	public FindLeadPage clickPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}
	
	public FindLeadPage enterPhoneNumber(String phone) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
		return this;
	}
	
	public FindLeadPage clickFindLeads() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	
	public ViewLeadPage clickFirstResult() {
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		return new ViewLeadPage(driver);
	}
	

}
