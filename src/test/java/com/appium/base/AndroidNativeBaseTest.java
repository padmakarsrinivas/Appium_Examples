package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidNativeBaseTest {
  public static AndroidDriver<?> mobiledriver;
  @BeforeTest
  public void beforeTest( ) throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    capabilities.setCapability("appPackage", "com.android.calculator2");
    capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest
  public void afterTest( ) {
    mobiledriver.quit();
  }
}
