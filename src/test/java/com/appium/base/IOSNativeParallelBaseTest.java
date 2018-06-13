package com.appium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSNativeParallelBaseTest {
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
    mobiledriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown( ) {
    mobiledriver.quit();
  }

}
