package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage(RemoteWebDriver receivedDriver) {	
		this.driver = receivedDriver;
	}
	
	public LoginPage enterUsername(String user) {
		driver.findElement(By.id("username")).sendKeys(user);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public WelcomePage clickLogin_positive() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage(driver);
	}
	
	public LoginPage clickLogin_negative() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return this;
	}


}
