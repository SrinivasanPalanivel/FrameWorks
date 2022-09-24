package testCases;

import org.testng.annotations.*;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class DuplicateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		xlfileName = "TC003";
	}

	@Test(dataProvider = "sendData", groups = "smoke")
	public void duplicateLeadTest(String user, String password, String cname, String fname, String lname, String role, String email, String state, String dcname, String dfname) {
		
		new LoginPage(driver).enterUsername(user).enterPassword(password)
		.clickLogin_positive().clickCRMSFA().clickLeads().clickCreateLead()
		.enterCompanyName(cname).enterFirstName(dfname).enterLastName(lname)
		.enterDiscription(role).enterEmail(email).enterState(state)
		.clickCreateLeadButton().clickDuplicateLead().clearAndEnterCompanyname(dcname)
		.clearAndEnterFirstname(dfname).clickCreateLead().getTitle();

	}

}