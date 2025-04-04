package Tests.Mobile.filter;

import PageObjects.FilterPage;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FilterByPropertyTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void filterByProperty() {

        // Variables
        String filterCategory = "Property";
        String filter = "Short sleeves";

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        FilterPage filterPage = new FilterPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click 'Clothes' in the header to navigate to Clothes listing");
        homePage.openHamburgerMenu();
        homePage.clickClothesLink();

        Reporter.log("Filter items by " + "'" + filter + "'");
        filterPage.filterBy(filterCategory, filter);

        Reporter.log("Verify that items are filtered by " + "'" + filter + "'");
        Assert.assertTrue(searchPage.getProductTitleText().contains("T-Shirt"), "Items are not filtered by " + "'" + filter + "'");
    }
}
