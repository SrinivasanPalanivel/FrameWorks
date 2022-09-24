package testCases;

import org.testng.annotations.*;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class CreateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		xlfileName = "TC001";
	}
    
	@Test(dataProvider = "sendData", groups = "Regression")
	public void createLeadTest(String user, String password, String cname, String fname, String lname, String dname, String role, String email, String state) {
		
		new LoginPage(driver).enterUsername(user).enterPassword(password)
		.clickLogin_positive().clickCRMSFA().clickLeads().clickCreateLead()
		.enterCompanyName(cname).enterFirstName(fname).enterLastName(lname)
		.enterDeptName(dname).enterDiscription(role).enterEmail(email)
		.enterState(state).clickCreateLeadButton().getLeadID();
		
}

}