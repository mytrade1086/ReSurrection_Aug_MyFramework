package cases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;
import pages.SignInPage;

public class RegistrationPageTest extends BaseTest {

	SignInPage sgn;
	RegistrationPage rgn;
	
	@Test
	public void Registration() throws Exception {
		
		sgn=land.signInClick();
		sgn.enterEmail("neha@desh.com");
		rgn=sgn.clickCreateAnAccount();	
		rgn.selectGender("female");
		rgn.enterFirstname("neha");
		rgn.enterLastName("deshmukh");
		rgn.enterEmailID("neha@desh.com");
		rgn.enterPassword("dummy");
		
		
		
		
	}
}
