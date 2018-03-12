package com.appium.browserTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * IOS Browser Sauce Labs Test.
 */
public class IOSBrowserSaucelabsTest 
{
	public static IOSDriver<?> mobiledriver;

	public static final String USERNAME = "YOUR_USERNAME";
	public static final String ACCESS_KEY = "YOUR_ACESS_KEY";
	public static final String URL = "https://"+USERNAME+":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


	@BeforeTest
	public void beforeTest( ) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new IOSDriver<>(new URL(URL), capabilities);
	}
	@Test
	public static void launchBrowser() throws InterruptedException
	{
		mobiledriver.get("http://www.google.com/");
	}

	@AfterTest
	public void afterTest()
	{
		mobiledriver.quit();
	}
}
