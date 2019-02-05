package com.appium.test;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 *  IOS Browser Local Test. 
 */
public class IOSBrowserLocalTest extends BaseTest{
  public static IOSDriver<?> mobiledriver;

  @BeforeTest
  public void beforeTest( ) throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new IOSDriver<>(getServiceUrl(), capabilities);
  }

  @AfterTest
  public void afterTest(){
    mobiledriver.quit();
  }

  @Test
  public static void launchBrowser(){
    mobiledriver.get("http://appium.io/");
    Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
    Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}