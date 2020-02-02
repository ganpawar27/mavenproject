package com.orange.pages;

import org.openqa.selenium.support.PageFactory;
import com.orange.hrm.*;



public class OrangeHrmClass 
{
	public OrangeHrmClass()
	{
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
public void getTittle()
{
	String str=WebDriverFactory.getDriver().getCurrentUrl();
	System.out.println(str);
}
}
