package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidNativeParallelBaseTest {
  public static AndroidDriver<?> mobiledriver;
  @BeforeTest(alwaysRun = true)
  @Parameters({"platform", "udid", "systemPort"}) 
  public void beforeTest(String Platform, String udid, String systemPort ) throws MalformedURLException {
    String[] platformInfo = Platform.split(" ");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.8.0");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformInfo[0]);
    capabilities.setCapability(MobileCapabilityType.UDID, udid);
    capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    capabilities.setCapability("appPackage", "com.android.calculator2");
    capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest(alwaysRun = true)
  public void afterTest( ) {
    mobiledriver.quit();
  }
}
