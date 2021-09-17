package com.solvd.savich.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement fieldSearch;

    @FindBy(css ="#nav-search-submit-button")
    private WebElement btnSearch;

    @FindBy(css ="span[class*=a-size-medium]")
    private List<WebElement> items;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.amazon.com/");
    }
    public List<WebElement> find(String query){
        fieldSearch.sendKeys(query);
        btnSearch.click();
        return items;
    }

    public List<String> getTextFieldItemsName(){
        List<String> names = new LinkedList<>();
        for(WebElement n : items) {
            names.add(n.getText());
        }
        return names;
    }
}
