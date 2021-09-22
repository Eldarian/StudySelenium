package com.solvd.savich.gui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NavigationMenu {

    WebDriver driver;

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

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.amazon.com/");
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        btnAll.click();
        btnComputers.click();
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
    //   Boolean isPresent = driver.findElements(By.cssSelector("a#attach-close_sideSheet-link.a-link-normal.close-button")).size() > 0;

    public void home() {
        driver.get("https://www.amazon.com/");
    }

    public boolean isButtonPresent() {
        return closeWindow != null;
    }

    public void backToHomePage() {
        backToHomePage.click();
    }

    public void btnCart() {
        btnCart.click();
    }

}

