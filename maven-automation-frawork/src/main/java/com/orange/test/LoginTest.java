package com.orange.test;

import org.testng.annotations.Test;

import com.orange.hrm.SeleniumBase;
import com.orange.pages.LoginPage;

public class LoginTest extends SeleniumBase
{
	@Test
	public void verifylogin()
	{
	LoginPage lp=new LoginPage();
	lp.verifyLinks();
	lp.verifyloginpanelname()
	.veriyInvalidUserName("ssds", "admin", "Invalid credentials")
	.verifyUsernameBlank("", "admin", "Username cannot be empty")	
	.verifyPasswordBlank("admin", "", "Password cannot be empty")
	.login("admin","admin")
	.verifyWelcomeTest("Welcome Admin");
	
	}

}