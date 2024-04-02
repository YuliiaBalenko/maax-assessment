package com.example.maax.pageobjects;

import com.example.maax.config.Config;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private static final String HOME_PAGE_URL = "https://" + Config.getProperty("host");

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    @FindBy(css = ".search-input.form-control")
    private WebElement searchInputField;

    @FindBy(xpath = "//a[@class='icon icon-search icon-big']//*[name()='svg']")
    private WebElement searchIcon;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(HOME_PAGE_URL);

        if (isAcceptAllCookiesButtonDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookiesBtn)).click();
        }
        return this;
    }

    private boolean isAcceptAllCookiesButtonDisplayed() {
        try {
            return acceptAllCookiesBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void searchForProduct(String productName) {
        searchInputField.clear();
        searchInputField.sendKeys(productName);
        searchIcon.click();
    }
}
