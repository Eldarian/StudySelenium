package com.solvd.savich.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DealsPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(), 'Today')]")
    private WebElement titleOfDealPage;

    @FindBy(css = ".a-button-text.a-declarative")
    private WebElement btnSortBy;

    @FindBy(css = "#sorting_dropdown0_1")
    private WebElement btnSortByDiscountLowToHigh;

    @FindBy(xpath = "//span[contains(text(),'Deal of the day')]")
    private WebElement btnDealOfTheDay;

    @FindBy(xpath = "//label//span[contains(text(),'Electronics')]")
    private WebElement btnFilterElectronics;

    @FindBy(css = "[data-testid='deal-card']")
    private List<WebElement> listOfItem;

    @FindBy(xpath = "//div[contains(@aria-label,'Deal price')]")
    private List<WebElement> goodsPrices;

    public DealsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String isPageOpened() {
        return titleOfDealPage.getText();
    }

    public void getSortBy() {
        btnSortBy.click();
        btnSortByDiscountLowToHigh.click();
    }

    public void btnDealOfTheDay() {
        btnDealOfTheDay.click();
    }

    public void selectFilterElectronics() {
        btnFilterElectronics.click();
    }

    public List<WebElement> getListOfItem() {
        return listOfItem;
    }

    public Double getGoodsPrice(String priceToParce) {
        String[] array = priceToParce.replaceAll
                ("\\$", "").replaceAll("-", "").split(" ");
        System.out.println("INFO: " + priceToParce + " " + array[0]);
        return Double.parseDouble(array[0]);
    }
}
