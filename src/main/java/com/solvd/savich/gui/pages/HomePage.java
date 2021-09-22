package com.solvd.savich.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {
    WebDriver driver;

    @FindBy(css = "#nav-hamburger-menu")
    private WebElement btnAll;

    @FindBy(xpath = "//div[contains(text(),'Computers')]")
    private WebElement btnComputers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.amazon.com/");
    }
}
