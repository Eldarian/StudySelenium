package com.solvd.savich;

import com.solvd.savich.gui.components.NavigationMenu;
import com.solvd.savich.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebTest.class);
    WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new RemoteWebDriver(DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openAmazon() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/");
    }

    @Test
    public void testSearchProducts() {
        SearchPage searchPage = new SearchPage(driver);
        List<WebElement> goods = searchPage.find("Mac");
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");

        List<String> namesOfTitle = searchPage.getTextFieldItemsName();
        for (String n : namesOfTitle) {
            LOGGER.info(n);
        }
    }

    @Test
    public void testAddToCart() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        int countCart1 = navigationMenu.countCart();
        navigationMenu.selectProduct();
        SearchPage searchItem = new SearchPage(driver);
        List<WebElement> goods = searchItem.getListItems();
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");

        int randomNum = (int) (Math.random() * searchItem.getListItems().size());
        WebElement item = searchItem.getListItems().get(randomNum);
        item.click();
        navigationMenu.addToCart();
        if (navigationMenu.isWindowPresent()) {
            navigationMenu.closeWindow();
        }
        navigationMenu.backToHomePage();
        Assert.assertTrue(navigationMenu.countCart() > countCart1, "The product has not been added to the cart");

        CartPage cartPage = new CartPage(driver);
        cartPage.cartHome();
        Assert.assertEquals(cartPage.getPageHeader(), "Shopping Cart");

        int countCart2 = navigationMenu.countCart();
        WebElement itemOfCart = cartPage.listOfCartItems().get(0).findElement(By.cssSelector("[value='Delete']"));
        itemOfCart.click();
        Assert.assertTrue(navigationMenu.countCart() < countCart2, "The product has not been deleted from the cart");
    }

    @Test
    public void testBuyNow() {
        SearchPage searchPage = new SearchPage(driver);
        List<WebElement> goods = searchPage.find("MacBook");
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");
        goods.get(0).click();
        searchPage.tapBtnBuyNow();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getTextLogin(), "Sign-In", "User is not on page authorisation");

        loginPage.authorization();
        BuyNowPage buyNowPage = new BuyNowPage(driver);
        Assert.assertEquals(buyNowPage.getSelectAddressText(), "Select a shipping address", "Page for choosing a payment and delivery method is not opened");
    }

    @Test
    public void testChangeCountry() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.getSelectAdress();
        String getTitleOfSelectedCountry = navigationMenu.changeCountry();
        navigationMenu.getTitleCurrentCountry();
        navigationMenu.btnDone();
        Assert.assertEquals(navigationMenu.getTitleOfCountryToDelivery(),
                getTitleOfSelectedCountry, "Don't change country on main page");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}