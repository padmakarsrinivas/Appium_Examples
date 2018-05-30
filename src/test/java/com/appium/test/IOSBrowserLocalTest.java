package com.appium.test;

import org.testng.annotations.Test;

import com.appium.base.IOSLocalBaseTest;

/**
 *  IOS Browser Local Test. 
 */
public class IOSBrowserLocalTest extends IOSLocalBaseTest 
{
	@Test
	public static void launchBrowser()
	{
		mobiledriver.get("http://www.google.com/");
	}
}