package week7.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class DuplicateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		xlfileName = "TC003";
	}

	@Test(dataProvider = "sendData", groups = "smoke")
	public void duplicateLeadTest(String user, String password, String cname, String fname, String lname, String role, String email, String state, String dcname, String dfname) {
		
		driver.findElement(By.id("username")).sendKeys(user);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		// Creating Lead
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys(role);
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select dd1 = new Select(eleState);
		dd1.selectByVisibleText(state);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println("Title : "+ driver.getTitle());
		
		// Duplicate Lead
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		WebElement eleCompany1 = driver.findElement(By.id("createLeadForm_companyName"));
		eleCompany1.clear();
		eleCompany1.sendKeys(dcname);
		
		WebElement eleFirst1 = driver.findElement(By.id("createLeadForm_firstName"));
		eleFirst1.clear();
		eleFirst1.sendKeys(dfname);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println("Title : "+ driver.getTitle());

	}

}