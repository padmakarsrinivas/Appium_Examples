package com.appium.test;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.base.BaseTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * IOS Native Application Parallel Test.
 */
public class IOSNativeParallelTest extends  BaseTest{
  public static IOSDriver<?> mobiledriver;
  @BeforeTest(alwaysRun = true)
  @Parameters({"platform", "udid", "deviceName", "wdaLocalPort"}) 
  public void beforeTest(String platform, String udid, String deviceName, String wdaLocalPort) throws MalformedURLException {
    String[] platformInfo = platform.split(" ");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.8.1");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformInfo[0]);
    capabilities.setCapability(MobileCapabilityType.UDID, udid);
    capabilities.setCapability("wdaLocalPort", wdaLocalPort);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");    
    capabilities.setCapability("xcodeOrgId", "YOUR_ORG_ID");
    capabilities.setCapability("xcodeSigningId", "iPhone Developer");
    capabilities.setCapability("udid", "DEVICE_UDID");
    capabilities.setCapability("newCommandTimeout", 2000);
    mobiledriver = new IOSDriver<>(getServiceUrl(), capabilities);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown( ) {
    mobiledriver.quit();
  }

  @Test
  public static void appTest(){
    mobiledriver.findElementById("2").click();
    mobiledriver.findElementByAccessibilityId("add").click();
    mobiledriver.findElementById("8").click();
    mobiledriver.findElementByAccessibilityId("equals").click();
    String results=mobiledriver.findElementById("Result").getText();
    Assert.assertEquals(results, "10", "Result Mismatch");
  }
}
