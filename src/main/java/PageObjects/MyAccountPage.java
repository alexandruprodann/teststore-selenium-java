package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class MyAccountPage extends BaseClass {

    // Elements
    public By informationBtn() {
        return By.cssSelector("#identity-link");
    }

    private By addFirstAddressBtn() {
        return By.cssSelector("#address-link");
    }

    private By orderHistoryBtn() {
        return By.cssSelector("#history-link");
    }

    private By creditSlipsBtn() {
        return By.cssSelector("#order-slips-link");
    }

    private By vouchersBtn() {
        return By.cssSelector("#discounts-link");
    }

    private By myWishlistsBtn() {
        return By.cssSelector("#wishlist-link");
    }

    private By gdprBtn() {
        return By.cssSelector("#psgdpr-link");
    }

    private By myAlertsBtn() {
        return By.cssSelector("#emailsalerts");
    }


    // Actions
    public void clickInformationBtn() {
        waitUntilElementIsClickable(informationBtn());
        getDriver().findElement(informationBtn()).click();
    }

    public void clickOrderHistoryBtn() {
        waitUntilElementIsClickable(orderHistoryBtn());
        getDriver().findElement(orderHistoryBtn()).click();
    }
}
