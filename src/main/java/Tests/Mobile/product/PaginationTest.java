package Tests.Mobile.product;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PaginationTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void productPagination() {

        // Variables
        String expectedPage = "2";

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click on 'All products' navigation link");
        homePage.clickAllProductsLink();

        Reporter.log("Scroll to bottom of page to verify pagination controls are displayed");
        Assert.assertTrue(isElementDisplayed(searchPage.paginationControls()), "Pagination controls are not displayed!");

        Reporter.log("Click 'Next' to proceed to the second page of results");
        searchPage.clickNext();

        Reporter.log("Verify URL parameter contains 'page=" + expectedPage + "' to confirm pagination is working");
        Assert.assertTrue(waitForUrlToContainBool("page=" + expectedPage), "Page " + expectedPage + " is not active!");
    }
}
