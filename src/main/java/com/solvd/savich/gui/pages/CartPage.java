package com.solvd.savich.gui.pages;

import com.solvd.savich.gui.Resource;
import com.solvd.savich.gui.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@id, 'sc-item')]")
    private List<WebElement> listOfCartItems;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    private WebElement titleOfCart;

    @FindBy(css = "[value='Delete']")
    private WebElement btnDeleteItem;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void cartHome() {
        driver.get(Util.getPropertiesValue(Resource.CONFIG,"url_card"));
    }

    public List<WebElement> listOfCartItems() {
        return listOfCartItems;
    }

    public void deleteFromCartItems() {
        btnDeleteItem.click();
    }

    public String getPageHeader() {
        return titleOfCart.getText();
    }

}
