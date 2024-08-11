package TestStore;

import PageObjects.LoginPage;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        driver.get(TestConstants.LOGIN_URL);

        // Create instance of the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Login Process
        loginPage.enterEmail(TestConstants.TEST_EMAIL);
        loginPage.enterPassword(TestConstants.TEST_PASSWORD);
        loginPage.clickLogin();

        // Assert current URL is the homepage URL
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = TestConstants.BASE_URL;
        Assert.assertEquals(currentUrl, expectedUrl, "The user is not redirected to the homepage.");
    }
}
