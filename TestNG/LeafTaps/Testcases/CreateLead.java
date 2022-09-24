package week7.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class CreateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		xlfileName = "TC001";
	}
    
	@Test(dataProvider = "sendData", groups = "Regression")
	public void createLeadTest(String user, String password, String cname, String fname, String lname, String dname, String role, String email, String state) {
		
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
		
		driver.findElement(By.name("departmentName")).sendKeys(dname);
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys(role);
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select dd1 = new Select(eleState);
		dd1.selectByVisibleText(state);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println("Title : "+ driver.getTitle());
		
}

}