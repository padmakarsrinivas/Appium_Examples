package com.appium.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.base.AndroidLocalBaseTest;

/**
 * Android Browser Local Test.
 */
public class AndoridBrowserLocalTest extends AndroidLocalBaseTest{
  @Test
  public void launchBrowser() throws MalformedURLException {
    mobiledriver.get("http://appium.io/");
    Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
    Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}
