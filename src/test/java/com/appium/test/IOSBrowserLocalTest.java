package com.appium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.IOSBrowseLocalBaseTest;

/**
 *  IOS Browser Local Test. 
 */
public class IOSBrowserLocalTest extends IOSBrowseLocalBaseTest{
  @Test
  public static void launchBrowser(){
    mobiledriver.get("http://appium.io/");
    Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
    Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}