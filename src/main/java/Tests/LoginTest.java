package Tests;

import PageObjects.LoginPage;
import Utilities.BaseClass;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void login() {
        getDriver().get(TestConstants.LOGIN_URL);

        // Pages
        LoginPage loginPage = new LoginPage();


        // Steps
        Reporter.log("Proceed to " + TestConstants.LOGIN_URL + " and log in to an account");
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(TestConstants.TEST_PASSWORD);
        loginPage.clickLogin();

        Reporter.log("Observe user is redirected to homepage after log in");
        String expectedUrl = TestConstants.BASE_URL;
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "The user was not successfully logged in (not redirected to the homepage). " +
                "\nCurrent URL is: " + getDriver().getCurrentUrl());

    }
}
