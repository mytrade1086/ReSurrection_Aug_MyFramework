package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import utils.WebUtil;

public class LandingPage extends Base{

private WebDriver driver;


/**
 * 
 * 
 */



// http://automationpractice.com/index.php

By link_Sign_in=By.cssSelector("a.login");
By txt_search = By.cssSelector("input[name='search_query']");
By submit_search=By.xpath("//button[@name='submit_search']");


public LandingPage(WebDriver driver) {
	this.driver=driver;
	el=new WebUtil(driver);
}

public SignInPage signInClick() {
el.doClick(link_Sign_in);
return new SignInPage(driver);
}
	
public void enterSearch(String searchText) {
		el.doSendKeys(txt_search, "some text", "Description");		
	}

public void submitSearch() {
	el.doClick(submit_search);
}





}
