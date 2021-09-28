package com.solvd.savich.gui;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {

    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<RemoteWebDriver> driver = ThreadLocal.withInitial(() -> new RemoteWebDriver(DesiredCapabilities.chrome()));

    public RemoteWebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
