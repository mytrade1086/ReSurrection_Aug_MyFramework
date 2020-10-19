package cases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;

//@Epic("Epic - 101 : design login page with different features...")
//@Story("US - 102 : design basic login page with singup, title and login form...")
//@Listeners(listeners.Listener.class)
public class LandingPageTest extends BaseTest {




	@Test
	public void dummy() throws InterruptedException {
		System.out.println("Using Thread:"+Thread.currentThread().getId());
		land.enterSearch("sumit");

	}
	
}
