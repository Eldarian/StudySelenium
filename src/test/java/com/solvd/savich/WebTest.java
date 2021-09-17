package com.solvd.savich;

import com.solvd.savich.gui.pages.SearchPage;

import org.apache.commons.collections.CollectionUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.lang.invoke.MethodHandles;
import java.util.List;

public class WebTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebTest.class);

    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/asavich/Documents/selenium/chromedriver93");
        WebDriver driver = new ChromeDriver();
        SearchPage page = PageFactory.initElements(driver, SearchPage.class);
        List<WebElement> goods = page.find("Mac");

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");
        List<String> namesOfTitle = page.getTextFieldItemsName();
        for (String n : namesOfTitle) {
            LOGGER.info(n);
        }

    }
}