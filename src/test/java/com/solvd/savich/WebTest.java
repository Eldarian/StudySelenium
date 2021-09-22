package com.solvd.savich;

import com.solvd.savich.gui.components.NavigationMenu;
import com.solvd.savich.gui.pages.CartPage;
import com.solvd.savich.gui.pages.SearchPage;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebTest.class);

    @Test
    public void testSearchProducts() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        SearchPage page = new SearchPage(driver);
        page.home();
        List<WebElement> goods = page.find("Mac");

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");
        List<String> namesOfTitle = page.getTextFieldItemsName();
        for (String n : namesOfTitle) {
            LOGGER.info(n);
        }

        driver.quit();
    }

    @Test
    public void testAddToCart() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        navigationMenu.home();
        // navigationMenu.closeWindow();
        //  navigationMenu.backToHomePage();
        int countCart2 = navigationMenu.countCart();
        Assert.assertTrue(countCart2 > countCart1, "The product has not been added to the cart");

        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getPageHeader(), "Shopping Cart");
        int countCart3 = navigationMenu.countCart();
        WebElement itemOfCart = cart.listOfCartItems().get(0).findElement(By.cssSelector("[value='Delete']"));
        itemOfCart.click();
        int countCart4 = navigationMenu.countCart();
        Assert.assertTrue(countCart4 < countCart3, "The product has not been deleted from the cart");
        driver.quit();
    }
}