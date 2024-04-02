package com.example.maax.steps;

import com.example.maax.driver.Driver;
import com.example.maax.pageobjects.ProductDetailsPage;
import com.example.maax.pageobjects.WhereToBuyPage;

public class ProductDetailsPageSteps {

    ProductDetailsPage productDetailsPage;
    WhereToBuyPage whereToBuyPage;

    public ProductDetailsPageSteps() {
        productDetailsPage = new ProductDetailsPage(Driver.getDriver());
        whereToBuyPage = new WhereToBuyPage(Driver.getDriver());
    }

    public void openWhereToBuyPage() {
        productDetailsPage.clickOnWhereToBuyBtn();
        whereToBuyPage.waitWhereToBuyPageIsLoaded();
    }

}
