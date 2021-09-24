package com.solvd.savich.gui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class NavigationMenu {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#nav-hamburger-menu")
    private WebElement btnAll;

    @FindBy(xpath = "//div[contains(text(),'Computers')]")
    private WebElement btnComputers;

    @FindBy(xpath = "//a[contains(text(),'Computer Components')]")
    private WebElement btnComputersComponents;

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCart;

    @FindBy(css = "#nav-cart-count")
    private WebElement cartCount;

    @FindBy(css = "a#attach-close_sideSheet-link.a-link-normal.close-button")
    private WebElement closeWindow;

    @FindBy(css = "a#nav-logo-sprites")
    private WebElement backToHomePage;

    @FindBy(css = "a#nav-cart")
    private WebElement btnCart;

    @FindBy(css = "#nav-global-location-popover-link")
    private WebElement btnSelectAdress;

    @FindBy(css = ".a-button-dropdown.a-button.a-button-span12")
    private WebElement btnSelectList;

    @FindBy(css = "a[href='javascript:void(0)']")
    private List<WebElement> countries;

    @FindBy(css = "#a-autoid-2-announce")
    private WebElement btnDone;

    @FindBy(css = "#nav-global-location-data-modal-action")
    private WebElement titleOfDelivery;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        btnAll.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Computers')]")));
        btnComputers.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Computer Components')]")));
        btnComputersComponents.click();
    }

    public void addToCart() {
        addToCart.click();
    }

    public int countCart() {
        return Integer.parseInt(cartCount.getText());
    }

    public void closeWindow() {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10).toMillis())
                .until(ExpectedConditions.visibilityOf(closeWindow)));
        element.click();
    }

    public boolean isWindowPresent() {
        return driver.findElements(By.cssSelector("a#attach-close_sideSheet-link.a-link-normal.close-button")).size() > 0;
    }

    public void backToHomePage() {
        backToHomePage.click();
    }

    public void btnCart() {
        btnCart.click();
    }

    public void getSelectAdress(){
     btnSelectAdress.click();
     btnSelectList.click();
    }

    public List<WebElement> getListCountries(){
        return countries;
    }
    public String getTitleCurrentCountry(){
        return btnSelectAdress.getText();
    }

    public void btnDone() {
        btnDone.click();
    }

    public String getTitleOfCountryToDelivery(){
        return titleOfDelivery.getText();
    }

    public String changeCountry(){
        int countryIndex = (int) (Math.random() * 246);
        WebElement currentCountry = countries.get(countryIndex);
        String nameCountry = currentCountry.getText();
        currentCountry.click();
        return nameCountry;
    }
}
