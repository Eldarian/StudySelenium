package com.solvd.savich.gui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;

public class DriverFactory {

   private DriverFactory()
        {
            //Do-nothing..Do not allow to initialize this class from outside
        }
        private static DriverFactory instance = new DriverFactory();

        public static DriverFactory getInstance()
        {
            return instance;
        }

        ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>() // thread local driver object for webdriver
        {
            @Override
            protected RemoteWebDriver initialValue()
            {
                return new ChromeDriver(); // can be replaced with other browser drivers
            }
        };

        public RemoteWebDriver getDriver() // call this method to get the driver object and launch the browser
        {
            return driver.get();
        }

        public void removeDriver() // Quits the driver and closes the browser
        {
            driver.get().quit();
            driver.remove();
        }
}
