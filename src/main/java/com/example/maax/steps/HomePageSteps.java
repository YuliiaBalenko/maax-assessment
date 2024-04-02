package com.example.maax.steps;

import com.example.maax.driver.Driver;
import com.example.maax.pageobjects.HomePage;

public class HomePageSteps {
    HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage(Driver.getDriver());
    }

    public void openHomePage() {
        homePage.open();
    }

    public void searchForProduct(String productName) {
        homePage.searchForProduct(productName);
    }
}
