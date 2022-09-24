package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	public ViewLeadPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	public ViewLeadPage getLeadID() {
		String leadID = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Created Lead ID : "+leadID);
		return this;
	}
	
	public EditLeadPage clickEdit() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		return new EditLeadPage(driver);
	}
	
	public DuplicateLeadPage clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}
	
	public ViewLeadPage clickDeleteLead() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		return this;
	}
	
	public ViewLeadPage getTitle() {
		System.out.println("Title : "+ driver.getTitle());
		return this;
	}
	
	public ViewLeadPage verifyChange(String confirm) {
		String com_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(com_name.contains(confirm))
		{
			System.out.println("Confirmed!!!");
		}
		else
		{
			System.out.println("Not Confirmed!!!");
		}
		return this;
	}

}
