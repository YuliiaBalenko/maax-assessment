package com.example.maax.steps;

import com.example.maax.config.Config;
import com.example.maax.driver.Driver;
import com.example.maax.pageobjects.ProductDetailsPage;
import com.example.maax.pageobjects.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchPageSteps {

    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    public SearchPageSteps() {
        searchPage = new SearchPage(Driver.getDriver());
        productDetailsPage = new ProductDetailsPage(Driver.getDriver());
    }

    private static final String PRODUCT_PAGE_URL = "https://" + Config.getProperty("host") + "/search?query=";
    public void verifyAllProductsContainSearchingName(String productName) {
        List<WebElement> items = searchPage.getAllProductsOnPage();
        for (WebElement item : items) {
            String itemText = item.getText().toLowerCase();
            Assert.assertTrue(itemText.contains(productName.toLowerCase()), "Item does not contain " + productName);
        }
    }

    public void verifySearchPageWithProductsIsLoaded(String productName) {
        searchPage.waitProductListIsLoaded();
        String pageUrl = searchPage.getCurrentUrl();
        Assert.assertTrue(pageUrl.equals(PRODUCT_PAGE_URL + productName));

    }

    public void openFirstFoundProduct() {
        searchPage.getAllProductsOnPage().get(0).click();
        productDetailsPage.waitProductDetailsPageIsLoaded();
    }
}
