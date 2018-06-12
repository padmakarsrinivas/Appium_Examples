package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.IOSNativeBaseTest;

/**
 * IOS Native Application Test.
 */
public class IOSNativeAppTest extends IOSNativeBaseTest{
  @Test
  public void nativeAppTest() {
    mobiledriver.findElementById("2").click();
    mobiledriver.findElementByAccessibilityId("add").click();
    mobiledriver.findElementById("8").click();
    mobiledriver.findElementByAccessibilityId("equals").click();
    String results=mobiledriver.findElementById("Result").getText();
    Assert.assertEquals(results, "10", "Result Mismatch");
  }
}