package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.IOSNativeParallelBaseTest;

/**
 * IOS Native Application Parallel Test.
 */
public class IOSNativeParallelTest extends  IOSNativeParallelBaseTest{

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
