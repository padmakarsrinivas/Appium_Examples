package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.AndroidNativeBaseTest;

/**
 * Android Native Local Test.
 */
public class AndroidNativeAppTest extends AndroidNativeBaseTest{
  @Test
  public void nativeAppTest() {
    mobiledriver.findElementById("com.android.calculator2:id/digit_2").click();
    mobiledriver.findElementByAccessibilityId("plus").click();
    mobiledriver.findElementById("com.android.calculator2:id/digit_8").click();
    mobiledriver.findElementByAccessibilityId("equals").click();
    String results=mobiledriver.findElementById("com.android.calculator2:id/result").getText();
    Assert.assertEquals(results, "10", "Result Mismatch");
  }
}