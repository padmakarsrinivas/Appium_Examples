package com.appium.browserTest;

import org.testng.annotations.Test;

import com.appium.base.IOSSauceLabsBaseTest;

/**
 * IOS Browser Sauce Labs Test.
 */
public class IOSBrowserSaucelabsTest extends IOSSauceLabsBaseTest 
{

	@Test
	public static void launchBrowser()
	{
		mobiledriver.get("http://www.google.com/");
	}
}
