package week7.day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class DeleteLead extends ProjectSpecificMethods {

	@BeforeTest
	public void setdata() {
		xlfileName = "TC004";
	}
	
	@Test(dataProvider = "sendData", groups = "smoke")
	public void deleteLeadTest(String user, String pass, String phone) throws InterruptedException {
				
		driver.findElement(By.id("username")).sendKeys(user);
		
		driver.findElement(By.id("password")).sendKeys(pass);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		String leadID = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String delete = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String delete1 = "No records to display";
		
		if(delete.equals(delete1))
		{
			System.out.println("Deletion Verifed SucessFully!!!");
		}
		else
		{
			System.out.println("Deletion Verifed Not SucessFully!!!");
		}
		

	}

}
