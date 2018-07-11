package com.appium.base;

import java.io.IOException;
import java.net.URL;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

  private static AppiumDriverLocalService service;

  @BeforeSuite
  public void globalSetup () throws IOException {
    service = AppiumDriverLocalService.buildDefaultService();
    service.start();
  }

  @AfterSuite
  public void globalTearDown () {
    service.stop();
  }

  public URL getServiceUrl () {
    return service.getUrl();
  }
}
