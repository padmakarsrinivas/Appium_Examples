package com.appium.browserTest;

import org.testng.annotations.Test;

import com.appium.base.AndroidSauceLabsBaseTest;

/**
 * Android Browser Sauce Labs Test.
 */
public class AndroidBrowserSaucelabsTest extends AndroidSauceLabsBaseTest 
{
	@Test
	public static void launchBrowser()
	{
		mobiledriver.get("http://www.google.com/");
	}
}
