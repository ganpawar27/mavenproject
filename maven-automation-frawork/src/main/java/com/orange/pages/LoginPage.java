package com.orange.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.hrm.*;



public class LoginPage 
{
@FindBy(id="txtUsername")	
WebElement userName;
@FindBy(id="txtPassword")
WebElement password;
@FindBy(id="btnLogin")
WebElement loginBtn;

@FindBy(id="spanMessage")
WebElement userNameBlank;

@FindBy(id="spanMessage")
WebElement invalidUserName;

@FindBy(linkText="OrangeHRM, Inc")
WebElement link;

@FindBy(id="logInPanelHeading")
WebElement loginPanelName;

@FindBy(id="spanMessage")
WebElement hardErrorMessage;

@FindBy(xpath="//span[text()='Password cannot be empty']")
WebElement passwordHarderror;


public LoginPage()
{
	PageFactory.initElements(WebDriverFactory.getDriver(), this);
}

//Login panelname
public LoginPage verifyloginpanelname()
{
	loginPanelName.isDisplayed();
	if(loginPanelName.isDisplayed()==true)
	{
		System.out.println("login panel name is displayed");
	}
	
	return this;
	
}

public LoginPage verifyUsernameBlank(String Uname,String correctPassword, String text)
{
	userName.sendKeys(Uname);
	password.sendKeys(correctPassword);
	loginBtn.click();
	
	Assert.assertEquals(userNameBlank.getText(), text);
	
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebDriverFactory.getDriver().navigate().refresh();
	return this;
	
}

public LoginPage verifyPasswordBlank(String correctUname,String Password, String text)
{
	
	userName.sendKeys(correctUname);
	password.sendKeys(Password);
	loginBtn.click();
	
	Assert.assertEquals(passwordHarderror.getText(), text);
	
	
	WebDriverFactory.getDriver().navigate().refresh();
	return this;
	
}

//invalidUsername hard error message verification and error message display
public LoginPage veriyInvalidUserName(String invalidUname , String correctPassword, String text )
{
	userName.sendKeys(invalidUname);
	password.sendKeys(correctPassword);
	loginBtn.click();
	
	Assert.assertEquals(invalidUserName.getText(), text);
	invalidUserName.isDisplayed();
	
	if(invalidUserName.isDisplayed()== true)
	{
		System.out.println("ok");
	}
	
	WebDriverFactory.getDriver().navigate().refresh();
	return this;
}
//Links Verify
public OrangeHrmClass verifyLinks()
{
	link.click();
	System.out.println(WebDriverFactory.getDriver().getTitle());
	return new OrangeHrmClass();
}

//login sucssesfull
public HomePage login(String struseName , String strpassword)
{
	
	userName.sendKeys(struseName);
	password.sendKeys(strpassword);
	loginBtn.click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new HomePage();
	
}




}
