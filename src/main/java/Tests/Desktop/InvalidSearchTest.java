package Tests.Desktop;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvalidSearchTest extends BaseClass {

    @Test(groups = {Platform.PC})
    public void invalidSearch() {

        String INVALID_SEARCH_TERM = "invalid search";

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Access TestStore Homepage: " + TestConstants.BASE_URL);
        getDriver().get(TestConstants.BASE_URL);

        Reporter.log("Search for: " + INVALID_SEARCH_TERM);
        homePage.searchFor(INVALID_SEARCH_TERM);

        Reporter.log("Verify that 'No matches were found for your search' message is displayed");
        Assert.assertTrue(isElementDisplayed(searchPage.productSearchNoMatches()), "The 'No matches were found for your search' message is NOT displayed");
    }

}
