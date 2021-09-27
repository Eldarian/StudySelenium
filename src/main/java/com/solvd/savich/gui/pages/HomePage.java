package com.solvd.savich.gui.pages;

import com.solvd.savich.gui.Resource;
import com.solvd.savich.gui.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(Util.getPropertiesValue(Resource.CONFIG, "url"));
    }

}
