package week7.day13;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class EditLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		xlfileName = "TC002";
	}

	@Test( dataProvider = "sendData", groups = "Regression", dependsOnMethods = "week7.day13.CreateLead.createLeadTest")
	public void editLeadTest(String user, String password, String find, String company, String confirm) {
		
		driver.findElement(By.id("username")).sendKeys(user);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(find);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Tamil'])[1]")).click();
		
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
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		
		String com_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(com_name.contains(confirm))
		{
			System.out.println("Confirmed!!!");
		}
		else
		{
			System.out.println("Not Confirmed!!!");
		}

	}

}