package com.solvd.savich.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SearchPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchPage.class);
    WebDriver driver;

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement fieldSearch;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement btnSearch;

    @FindBy(css = "span[class*=a-size-medium]")
    private List<WebElement> items;

    @FindBy(css = "div.a-section.a-spacing-medium") //div[class*=s-card-container]>div
    private List<WebElement> itemsFromComputersSearch;

    @FindBy(css = "div[class*=s-card-container]>div")
    private WebElement itemsLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void home() {
        driver.get("https://www.amazon.com/");
    }


    public List<WebElement> find(String query) {
        fieldSearch.sendKeys(query);
        btnSearch.click();
        return items;
    }

    public List<String> getTextFieldItemsName() {
        List<String> names = new LinkedList<>();
        for (WebElement n : items) {
            names.add(n.getText());
        }
        return names;
    }

    public List<WebElement> getListItems() {
        return itemsFromComputersSearch;
    }
//    public List<WebElement> getListItems() {
//    return wait.until(ExpectedConditions.stalenessOf(itemsFromComputersSearch));
//    }

    //    public List<WebElement> getListItems3() {
//           return wait.until(ExpectedConditions.stalenessOf(itemsFromComputersSearch));
//
//    }
    public void tapItemLink() {
        itemsLink.click();
    }

}
