package com.appium.test;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsDesktopAppTest extends BaseTest{
	public static WindowsDriver<?> driver;

	@BeforeTest
	public void setup( ){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("platformName","Windows");
		capabilities.setCapability("deviceName", "WindowsPC");
		capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		capabilities.setCapability("newCommandTimeout", 2000);
		driver = new WindowsDriver<>(getServiceUrl(), capabilities);
	}

	@AfterTest
	public void tearDown( ) 
	{
		driver.quit();
	}

	@Test
	public void test() 
	{
		driver.findElementByName("One").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("Two").click();
		driver.findElementByName("Equals").click();
		Assert.assertEquals(driver.findElementByAccessibilityId("CalculatorResults").getText(), "Display is 3");
	}

}
