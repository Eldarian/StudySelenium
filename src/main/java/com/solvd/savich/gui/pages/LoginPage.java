package com.solvd.savich.gui.pages;

import com.solvd.savich.gui.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
    WebDriver driver;

    @FindBy(css = "h1.a-spacing-small")
    private WebElement textLogin;

    @FindBy(css = "[name='email']")
    private WebElement emailField;

    @FindBy(css = "input[id='continue']")
    private WebElement btnContinue;

    @FindBy(css = "[name='password']")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement btnSignIn;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement textLoginUser;

    @FindBy(xpath = "//h1[contains(text(),'Select a shipping address')]")
    private WebElement selectAddress;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextLogin(){
        return textLogin.getText();
    }
    public String getTextLoginUser(){
        return textLoginUser.getText();
    }

    public void authorization(){
        emailField.sendKeys(Util.getPropertiesValue("login"));
        btnContinue.click();
        passwordField.sendKeys(Util.getPropertiesValue("password"));
        btnSignIn.click();
    }




}
