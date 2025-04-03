package Tests.Desktop.sort;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static PageObjects.SearchPage.DropdownOptions.NAME_A_TO_Z;
import static PageObjects.SearchPage.DropdownOptions.NAME_Z_TO_A;

public class SortByNameTest extends BaseClass {

    @Test(groups = {Platform.PC})
    public void sortByNameAtoZ() {

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Accessories' in the header to navigate to Accessories listing");
        homePage.clickAccessoriesLink();

        Reporter.log("Sort items by " + NAME_A_TO_Z);
        searchPage.sortBy(NAME_A_TO_Z);

        Reporter.log("Verify that items are sorted alphabetically, A to Z");
        Assert.assertTrue(searchPage.areItemsSortedByName("AtoZ"), "Items are not sorted alphabetically, A to Z!");
    }

    @Test(groups = {Platform.PC})
    public void sortByNameZtoA() {

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Accessories' in the header to navigate to Accessories listing");
        homePage.clickAccessoriesLink();

        Reporter.log("Sort items by " + NAME_Z_TO_A);
        searchPage.sortBy(NAME_Z_TO_A);

        Reporter.log("Verify that items are sorted by name, Z to A");
        Assert.assertTrue(searchPage.areItemsSortedByName("ZtoA"), "Items are not sorted by name, Z to A!");
    }
}
