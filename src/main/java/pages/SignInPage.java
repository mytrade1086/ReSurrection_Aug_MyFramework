package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import utils.WebUtil;


public class SignInPage extends Base {
	
	/**
	 * 
	 * 
	 */

   WebDriver driver;
   public SignInPage(WebDriver driver) {
		this.driver = driver;
		el=new WebUtil(driver);
	}
   
   By lbl_create_an_account=By.xpath("//h3[text()='Create an account']");
   By txt_email=By.xpath("//input[@name='email_create']");
   By btn_Submit_Create=By.xpath("//button[@id='SubmitCreate']");
   
   public boolean  pageLoaded() {
	   return   el.doIsDisplayed(lbl_create_an_account);	   
   }
   
   public void enterEmail(String emailaddress) {   
	   el.doSendKeys(txt_email, emailaddress, "email address entered");
   }
   
	public RegistrationPage clickCreateAnAccount() {
		el.doClick(btn_Submit_Create);
		return new RegistrationPage(driver);
	}

   
   
   
   
	
}
