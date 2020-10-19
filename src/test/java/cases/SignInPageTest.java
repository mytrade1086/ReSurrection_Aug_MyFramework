package cases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignInPage;

//@Listeners(listeners.Listener.class)
public class SignInPageTest extends BaseTest {
SignInPage sg;
	

	@Test
	public void two() throws InterruptedException {
		System.out.println("Using Thread:"+Thread.currentThread().getId());
		sg=land.signInClick();
		sg.pageLoaded();
		sg.enterEmail("s@s.com");
		sg.clickCreateAnAccount();
		
		
		
	}
	

	
}
	