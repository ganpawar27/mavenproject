package com.orange.hrm;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory 
{
private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();

public static void setDriver(WebDriver driver)
{
	threadLocal.set(driver);
}
public static WebDriver getDriver()
{
	return threadLocal.get();
	 
}

}
