package pages;

import org.openqa.selenium.WebDriver;

import base.Base;
import utils.Constants;
import utils.WebUtil;

public class MyAccountPage extends Base{
//	http://automationpractice.com/index.php?controller=my-account
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
	this.driver = driver;
	el=new WebUtil(driver);
	}
	
	
	
	public String getPageTitle() {
		return el.waitForTitleToBePresent(Constants.MY_ACCOUNT_PAGE_TITLE, Constants.EXPLICIT_WAIT_TIMEOUT);	
	}
	
	

	
		
		
}
