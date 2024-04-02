package com.example.maax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProductsOnPage() {
        return driver.findElements(By.cssSelector(".product-card"));
    }

    public void waitProductListIsLoaded() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector( ".search-content.section.bg2.show")));
    }
}
