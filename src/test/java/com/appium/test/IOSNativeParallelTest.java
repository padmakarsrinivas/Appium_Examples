package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.IOSParallelBaseTest;

import io.appium.java_client.ios.IOSElement;

public class IOSNativeParallelTest extends  IOSParallelBaseTest{

  @Test
  public static void appTest(){

    IOSElement buttons = (IOSElement) mobiledriver.findElementByXPath("//XCUIElementTypeStaticText[@name='Buttons']");

    buttons.click();
    IOSElement title = (IOSElement)mobiledriver.findElementByXPath("//XCUIElementTypeNavigationBar[@name='Buttons']");
   
    Assert.assertEquals(title.getAttribute("name"), "Buttons", "Header Mismatch");
  }
}
