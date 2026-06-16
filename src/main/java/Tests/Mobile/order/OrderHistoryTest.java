package Tests.Mobile.order;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.OrderHistoryPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderHistoryTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void orderHistory() {

        // Pages
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage();

        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click Sign In button");
        homePage.clickSignIn();

        Reporter.log("Log in as configured test account");
        loginPage.loginAs(TestConstants.getTestEmail(), TestConstants.getTestPassword());

        Reporter.log("Proceed to My Account -> Order History and Details");
        homePage.clickMyAccountLink();
        myAccountPage.clickOrderHistoryBtn();

        Reporter.log("Verify that past orders are displayed in a table format");
        Assert.assertTrue(isElementDisplayed(orderHistoryPage.orderHistoryTable()), "The order history table is not displayed!");
    }
}
