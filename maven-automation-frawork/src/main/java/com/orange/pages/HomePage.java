package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.orange.hrm.*;


public class HomePage 
{
@FindBy(id="welcome")
WebElement welComeTest;

@FindBy(id="menu_admin_viewAdminModule")
WebElement adminMenu;

public HomePage()
{
	PageFactory.initElements(WebDriverFactory.getDriver(), this);
}

public HomePage verifyWelcomeTest(String text)
{
	Assert.assertEquals(welComeTest.getText(), text);
	System.out.println("Login sucessfull");
	return this;
}
}
