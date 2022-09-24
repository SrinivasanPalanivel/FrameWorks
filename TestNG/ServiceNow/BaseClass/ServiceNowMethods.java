package marathon_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowMethods {

		public WebDriver driver;
		
		@Parameters({"url", "username", "password"})
		
		@BeforeMethod
		public void beforeTest(String url, String username, String password) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.findElement(By.id("user_name")).sendKeys(username);
			driver.findElement(By.id("user_password")).sendKeys(password);
			driver.findElement(By.id("sysverb_login")).click();

		}
		
		@AfterMethod
		public void afterTest() {
			driver.quit();
		}

}
