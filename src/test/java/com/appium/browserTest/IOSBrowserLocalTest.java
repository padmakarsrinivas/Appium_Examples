package com.appium.browserTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 *  IOS Browser Local Test. 
 */
public class IOSBrowserLocalTest extends BaseTest 
{
	public static IOSDriver<?> mobiledriver;

	@Test
	public static void launchBrowser() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		mobiledriver.get("http://www.google.com/");

		mobiledriver.quit();
	}
}
