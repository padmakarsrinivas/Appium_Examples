package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSBrowseLocalBaseTest {

	public static IOSDriver<?> mobiledriver;

	@BeforeTest
	public void beforeTest( ) throws MalformedURLException 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@AfterTest
	public void afterTest( ) 
	{
		mobiledriver.quit();
	}
}
