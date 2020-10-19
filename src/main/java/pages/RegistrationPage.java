package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import utils.WebUtil;

public class RegistrationPage extends Base {
	/**
	 * http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation
	 */

	WebDriver driver;
	public RegistrationPage(WebDriver driver) {	
		this.driver=driver;
		el=new WebUtil(driver);
	}
	
	By rdoMale=By.xpath("//div[@id='uniform-id_gender1']");
	By rdoFemale=By.xpath("//div[@id='uniform-id_gender2']");
	
	By txt_First_Name=By.xpath("//input[@id='customer_firstname']");
	By txt_Last_Name=By.xpath("//input[@id='customer_lastname']");
	By txt_EmailId=By.xpath("//input[@id='email']");
	By txt_Password=By.xpath("//input[@id='passwd']");
	
	//Select
	By sel_Days=By.xpath("//select[@id='days']");
	By sel_Months=By.xpath("//select[@id='months']");
	By sel_Years=By.xpath("//select[@id='years']");
	
	//Checkboxes
	By chk_Newsletter=By.xpath("//input[@type='checkbox' and @name='newsletter']");
	By chk_ReceiveSpecialOffer=By.xpath("//input[@type='checkbox' and @name='optin']");
	
	//Address Form
	By txt_FirstName=By.xpath("//input[@id='firstname']");
	By txt_LastName=By.xpath("//input[@id='lastname']");
	By txt_Company=By.xpath("//input[@id='company']");
	By txt_Adress1=By.xpath("//input[@id='address1']");
	By txt_Adress2=By.xpath("//input[@id='address2']");
	By txt_City=By.xpath("//input[@id='city']");
	
	//Select
	By sel_State=By.xpath("//select[@id='id_state']");
	By txt_PostCode=By.xpath("//input[@id='postcode']");
	//
	By sel_Country=By.xpath("//select[@id='id_country']");
	//
	By txt_Additional_Information=By.xpath("//textarea[@id='other']");
	By txt_HomePhone=By.xpath("//input[@id='phone']");
	By txt_MobilePhone=By.xpath("//input[@id='phone_mobile']");
	By txt_AliasForAddress=By.xpath("//input[@id='alias']");
	By btn_Register=By.xpath("button[@id='submitAccount']"); ////button[@id='submitAccount']
	
	
	public void selectGender(String Gender) throws Exception {		
		if(Gender.trim().equalsIgnoreCase("male")) {
			el.doClick(rdoMale);
		}
		else if(Gender.trim().equalsIgnoreCase("female")) {
			el.doClick(rdoMale);
		}
		else
		{
			throw new Exception("Gender does not have acceptable values");	
		}
		}
		
	
	public void enterFirstname(String firstName) {
		el.doSendKeys(txt_First_Name, firstName, "first name entered");	
	}
	
	public void enterLastName(String lastName) {
		el.doSendKeys(txt_Last_Name, lastName, "last name entered");	
	}
	
	public void enterEmailID(String emailId) {
		el.doSendKeys(txt_EmailId, emailId, "email id entered");	
	}
	
	public void enterPassword(String password) {
		el.doSendKeys(txt_Password, password, "password entered");	
	}
	

	
	
	
	
	
	
}
