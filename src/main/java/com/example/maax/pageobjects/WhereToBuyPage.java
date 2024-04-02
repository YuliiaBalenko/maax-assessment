package com.example.maax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WhereToBuyPage extends BasePage{
    private static final String LOCATION_LIST_CSS_SELECTOR = ".col-12.col-lg-8.col-xl-9:nth-child(2)";

    @FindBy(css = ".mapboxgl-ctrl-geocoder--input")
    private WebElement searchLocationInputField;

    @FindBy(css = ".btn.btn-outline.btn-location")
    private WebElement getMyLocationBtn;

    @FindBy(css = ".count")
    private WebElement numberOfDealers;

    public WhereToBuyPage(WebDriver driver) {
        super(driver);
    }

    public void waitWhereToBuyPageIsLoaded() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath( "//section[@data-page='StoreLocator']")));
    }

    public void searchForLocation(String location) {
        searchLocationInputField.clear();
        searchLocationInputField.sendKeys(location);
        searchLocationInputField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getAllFoundLocationsOnPage() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(LOCATION_LIST_CSS_SELECTOR)));
        return driver.findElements(By.cssSelector(LOCATION_LIST_CSS_SELECTOR));
    }

    public void clickOnGetMyLocationBtn() {
        getMyLocationBtn.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfDealers));
    }

    public int getNumberOfAuthorizedDealers() {
        return Integer.parseInt(numberOfDealers.getText());
    }

}
