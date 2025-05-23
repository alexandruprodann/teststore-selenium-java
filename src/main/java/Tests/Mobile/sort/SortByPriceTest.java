package Tests.Mobile.sort;

import PageObjects.*;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static PageObjects.SearchPage.DropdownOptions.PRICE_HIGH_TO_LOW;
import static PageObjects.SearchPage.DropdownOptions.PRICE_LOW_TO_HIGH;

public class SortByPriceTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void sortByPriceHighToLow() {

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Accessories' in the header to navigate to Accessories listing");
        homePage.openHamburgerMenu();
        homePage.clickAccessoriesLink();

        Reporter.log("Sort items by " + PRICE_HIGH_TO_LOW);
        searchPage.sortBy(PRICE_HIGH_TO_LOW);

        Reporter.log("Verify that items are sorted by descending price");
        Assert.assertTrue(searchPage.areItemsSortedByPrice("descending"), "Items are not sorted by descending price!");
    }


    @Test(groups = {Platform.MOBILE})
    public void sortByPriceLowToHigh() {

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Accessories' in the header to navigate to Accessories listing");
        homePage.openHamburgerMenu();
        homePage.clickAccessoriesLink();

        Reporter.log("Sort items by " + PRICE_LOW_TO_HIGH);
        searchPage.sortBy(PRICE_LOW_TO_HIGH);

        Reporter.log("Verify that items are sorted by ascending price");
        Assert.assertTrue(searchPage.areItemsSortedByPrice("ascending"), "Items are not sorted by ascending price!");
    }
}
