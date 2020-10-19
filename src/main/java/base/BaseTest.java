package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pages.LandingPage;

public class BaseTest {
	protected WebDriver driver;
	protected Base base;
	protected Properties prop;
	protected LandingPage land;

	@BeforeTest
	public void extent_init() {
		Base.setExtent();
	}
	
	@AfterTest
	public void exten_flush() {
		Base.flushExtent();
		
	}

	@BeforeMethod
	public void setUP() {
	//	System.out.println(System.currentTimeMillis());
		base = new Base();
		prop = base.init_Prop();
		driver = base.init_Driver(prop);
		land = new LandingPage(driver);
		// System.out.println("Normal:"+base.normal +" staticvar:"+base.staticvar);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println("%%%%%%%INSIDE  AFTER METHOD " + "Execution ended at " + System.currentTimeMillis());
		if (driver != null) {
			driver.quit();
		}

//		if (Base.extent != null) {
//			Base.extent.flush();
//		}

	}
}
