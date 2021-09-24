package com.solvd.savich.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyNowPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'Select a shipping address')]")
    private WebElement selectAddress;

    public BuyNowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getSelectAddressText(){return selectAddress.getText();}

}
