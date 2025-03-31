package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MyWishlistsPage extends BaseClass {

    // Elements
    private By myWishlistLink() {
        return By.cssSelector(".wishlist-list-item-link");
    }

    private By productTitle() {
        return By.cssSelector(".wishlist-product-title");
    }

    public By productTitleWithText(String title) {
        return By.xpath("//p[normalize-space()='" + title + "']");
    }

    private By removeProductBtn() {
        return By.cssSelector(".wishlist-button-add");
    }

    private By confirmRemoveModalBtn() {
        return By.cssSelector(".modal-footer .btn-primary");
    }

    private By wishlistItem() {
        return By.cssSelector("li.wishlist-products-item");
    }


    // Actions
    public void clickMyWishlistLink() {
        waitUntilElementIsClickable(myWishlistLink());
        getDriver().findElement(myWishlistLink()).click();
    }

    public void removeProductFromWishlist(String productName) {
        List<WebElement> wishlistItems = getDriver().findElements(wishlistItem());

        for (WebElement item : wishlistItems) {
            String productTitleText = item.findElement(productTitle()).getText();
            WebElement removeButton = item.findElement(removeProductBtn());

            if (productTitleText.equals(productName)) {
                removeButton.click();
                break;
            }
        }

        waitUntilElementIsVisible(confirmRemoveModalBtn());
        getDriver().findElement(confirmRemoveModalBtn()).click();
    }


}
