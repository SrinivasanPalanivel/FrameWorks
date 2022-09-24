package testCases;

import org.testng.annotations.*;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class EditLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		xlfileName = "TC002";
	}

	@Test( dataProvider = "sendData", groups = "Regression")
	public void editLeadTest(String user, String password, String find, String company, String confirm) {
		
		new LoginPage(driver).enterUsername(user).enterPassword(password)
		.clickLogin_positive().clickCRMSFA().clickLeads().clickFindLead().enterFirstname(find)
		.clickFindLeads().clickFirstResult().clickEdit().clearAndEnterCompanyName(company)
		.clickUpdate().verifyChange(confirm);
	}

}