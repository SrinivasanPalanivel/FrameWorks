package testCases;

import org.testng.annotations.*;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteLead extends ProjectSpecificMethods {

	@BeforeTest
	public void setdata() {
		xlfileName = "TC004";
	}
	
	@Test(dataProvider = "sendData", groups = "smoke")
	public void deleteLeadTest(String user, String pass, String phone) throws InterruptedException {
		
		new LoginPage(driver).enterUsername(user).enterPassword(pass).clickLogin_positive()
		.clickCRMSFA().clickLeads().clickFindLead().clickPhone().enterPhoneNumber(phone)
		.clickFirstResult().clickDeleteLead();
				
		

	}

}
