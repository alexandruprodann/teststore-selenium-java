package Tests.Mobile.auth;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void login() {

        // Pages
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.LOGIN_URL);
        getDriver().get(TestConstants.LOGIN_URL);

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(TestConstants.TEST_PASSWORD);
        loginPage.clickLogin();

        Reporter.log("Check if the user is successfully logged in");
        homePage.clickMyAccountLink();
        Assert.assertTrue(isElementDisplayed(myAccountPage.informationBtn()), "User was not logged in!");
    }


    @Test(groups = {Platform.MOBILE})
    public void invalidLogin() {

        // Variables
        String invalidPassword = "Invalid123";

        // Pages
        LoginPage loginPage = new LoginPage();

        // Steps
        Reporter.log("Proceed to " + TestConstants.LOGIN_URL);
        getDriver().get(TestConstants.LOGIN_URL);

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLogin();

        Reporter.log("Verify that the authentication failed");
        Assert.assertTrue(isElementDisplayed(loginPage.authFailedAlert()), "'Authentication failed' alert is not visible");
    }
}
