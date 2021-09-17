package com.solvd.savich;

import com.solvd.savich.gui.pages.SearchPage;

import org.apache.commons.collections.CollectionUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class WebTest {

    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/asavich/Documents/selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        SearchPage page = PageFactory.initElements(driver, SearchPage.class);
        List<WebElement> goods = page.find("Mac");

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");
        List<String> namesOfTitle = page.getTextFieldItemsName();
        for (String n : namesOfTitle) {
            System.out.println(n);
        }

    }
}