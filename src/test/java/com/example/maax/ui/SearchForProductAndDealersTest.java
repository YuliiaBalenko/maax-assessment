package com.example.maax.ui;

import com.example.maax.steps.HomePageSteps;
import com.example.maax.steps.ProductDetailsPageSteps;
import com.example.maax.steps.SearchPageSteps;
import com.example.maax.steps.WhereToBuyPageSteps;
import org.testng.annotations.Test;

public class SearchForProductAndDealersTest extends BaseTest {

    @Test
    public void userSearchingForValidProduct() {
        String productName = "bathtub";
        HomePageSteps homePageSteps = new HomePageSteps();
        homePageSteps.openHomePage();
        homePageSteps.searchForProduct(productName);

        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.verifySearchPageWithProductsIsLoaded(productName);
        searchPageSteps.verifyAllProductsContainSearchingName(productName);
    }

    @Test
    public void userSearchingForDealersForProductViaSearch() {
        userSearchingForValidProduct();

        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.openFirstFoundProduct();

        ProductDetailsPageSteps productPageSteps = new ProductDetailsPageSteps();
        productPageSteps.openWhereToBuyPage();

        WhereToBuyPageSteps whereToBuyPageSteps = new WhereToBuyPageSteps();
        String searchingLocation = "Montreal";
        whereToBuyPageSteps.searchForLocation(searchingLocation);
        whereToBuyPageSteps.verifyAllDealersContainSearchingLocation("QC");
    }

    @Test
    public void userSearchingForDealersForProductViaGetMyLocationBtn() {
        userSearchingForValidProduct();

        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.openFirstFoundProduct();

        ProductDetailsPageSteps productPageSteps = new ProductDetailsPageSteps();
        productPageSteps.openWhereToBuyPage();

        WhereToBuyPageSteps whereToBuyPageSteps = new WhereToBuyPageSteps();
        whereToBuyPageSteps.verifyNumberOfAuthorizedDealersForGetMyLocationOption();
    }
}
