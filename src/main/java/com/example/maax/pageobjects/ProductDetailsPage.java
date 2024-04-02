package com.example.maax.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'buttons-row')]//a[contains(@class, 'where-to-buy')]")
    private WebElement whereToBuyBtn;

    @FindBy(css = ".product-list-container.row")
    private WebElement productListContainer;

    public void clickOnWhereToBuyBtn() {
        whereToBuyBtn.click();
    }
    public void waitProductDetailsPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath( "//div[@data-page='ProductDetail']")));
    }
}
