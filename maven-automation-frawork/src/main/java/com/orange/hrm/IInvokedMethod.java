package com.orange.hrm;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class IInvokedMethod implements IInvokedMethodListener 								
{
	public void afterInvocation(org.testng.IInvokedMethod method, ITestResult testResult)
	
	 {
		// TODO Auto-generated method stub
		WebDriverFactory.getDriver().quit();
		
	}
	public void beforeInvocation(org.testng.IInvokedMethod method, ITestResult testResult)
	
	 {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("78");
		
		
		try {
			WebDriver dr = new RemoteWebDriver(new URL("http://192.168.43.27:4444/wd/hub"), capabilities);
			WebDriverFactory.setDriver(dr);
			WebDriverFactory.getDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
