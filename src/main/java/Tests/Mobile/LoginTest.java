package Tests.Mobile;

import PageObjects.LoginPage;
import Utilities.BaseClass;
import Utilities.Platform;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(groups = {Platform.MOBILE})
    public void login() {

        // Pages
        LoginPage loginPage = new LoginPage();


        // Steps
        Reporter.log("Proceed to " + TestConstants.LOGIN_URL);
        getDriver().get(TestConstants.LOGIN_URL);

        Reporter.log("Login as (" + TestConstants.TEST_EMAIL + "/" + TestConstants.TEST_PASSWORD + ")");
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(TestConstants.TEST_PASSWORD);
        loginPage.clickLogin();

        Reporter.log("Observe user is redirected to homepage after log in");
        Assert.assertTrue(waitForUrlToContainBool(TestConstants.BASE_URL), "The user was not successfully logged in (not redirected to the homepage). " +
                "\nCurrent URL is: " + getDriver().getCurrentUrl());

    }
}
