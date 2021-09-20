package com.solvd.savich;

import com.solvd.savich.gui.pages.SearchPage;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebTest.class);

    @Test
    public void testSearchProducts() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "93");
        chromeOptions.setCapability("platformName", "Mac OC");
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        SearchPage page = PageFactory.initElements(driver, SearchPage.class);
        List<WebElement> goods = page.find("Mac");

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "Goods not found!");
        List<String> namesOfTitle = page.getTextFieldItemsName();
        for (String n : namesOfTitle) {
            LOGGER.info(n);
        }
        assert driver != null;
        driver.quit();
    }
}