package com.example.maax.steps;

import com.example.maax.driver.Driver;
import com.example.maax.pageobjects.WhereToBuyPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WhereToBuyPageSteps {

    WhereToBuyPage whereToBuyPage;
    public WhereToBuyPageSteps() {
        whereToBuyPage = new WhereToBuyPage(Driver.getDriver());
    }

    public void searchForLocation(String locationName) {
        whereToBuyPage.searchForLocation(locationName);
    }

    public void verifyAllDealersContainSearchingLocation(String locationName) {
        List<WebElement> locations = whereToBuyPage.getAllFoundLocationsOnPage();
        for (WebElement location : locations) {
            String itemText = location.getText().toLowerCase();
            Assert.assertTrue(itemText.contains(locationName.toLowerCase()), "Appeared location does not contain " + locationName);
        }
    }

    public void verifyNumberOfAuthorizedDealersForGetMyLocationOption() {
        whereToBuyPage.clickOnGetMyLocationBtn();
        Assert.assertTrue(whereToBuyPage.getNumberOfAuthorizedDealers() > 0, "No dealers in chosen location");
    }
}
