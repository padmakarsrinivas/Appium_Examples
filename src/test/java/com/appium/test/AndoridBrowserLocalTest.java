package com.appium.test;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import com.appium.base.AndroidLocalBaseTest;

/**
 * Android Browser Local Test.
 */
public class AndoridBrowserLocalTest extends AndroidLocalBaseTest 
{
	@Test
	public void launchBrowser() throws MalformedURLException
	{
		mobiledriver.get("http://www.google.com/");
	}
}
