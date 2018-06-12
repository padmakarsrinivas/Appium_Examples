package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidLocalBaseTest {

	public static AndroidDriver<?> mobiledriver;
	@BeforeTest
	public void beforeTest( ) throws MalformedURLException 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S4 Emulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		capabilities.setCapability("newCommandTimeout", 2000);
		mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@AfterTest
	public void afterTest( ) 
	{
		mobiledriver.quit();
	}
}
