package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BaseClass {

    // Elements
    public By productTitle() {
        return By.cssSelector(".h1");
    }

    public By productPrice() {
        return By.cssSelector(".current-price");
    }

    public By productImage() {
        return By.cssSelector(".product-cover");
    }

    public By productShortDescription() {
        return By.xpath("(//div[@class='product-description']//p)[1]");
    }

    public By productLongDescription() {
        return By.cssSelector("#description");
    }

    private By sizeSelector() {
        return By.cssSelector("#group_1");
    }

    private By quantityIncreaseBtn() {
        return By.cssSelector(".bootstrap-touchspin-up");
    }

    private By quantityDecreaseBtn() {
        return By.cssSelector(".bootstrap-touchspin-down");
    }

    private By quantityInput() {
        return By.cssSelector("input#quantity_wanted");
    }

    private By sizeLabel() {
        return By.cssSelector("div:nth-of-type(1) > .control-label");
    }

    public By addToCartBtn() {
        return By.cssSelector(".add-to-cart");
    }

    private By homeLink() {
        return By.linkText("Home");
    }

    private By addToWishlist() {
        return By.cssSelector(".wishlist-button-add.wishlist-button-product");
    }

    public By wishlistSuccessAlert() {
        return By.cssSelector(".wishlist-toast.success");
    }

    public By breadCrumb() {
        return By.cssSelector(".breadcrumb");
    }

    // Modal buttons
    private By proceedToCheckoutBtn() {
        return By.cssSelector(".modal-body .btn.btn-primary");
    }

    private By continueShoppingBtn() {
        return By.cssSelector(".modal-body .btn.btn-secondary");
    }

    private By myWishlistBtn() {
        return By.cssSelector(".wishlist-list-item");
    }


    // Actions
    public void selectSize(String size) {
        waitUntilElementIsClickable(sizeSelector());
        Select select = new Select(getDriver().findElement(sizeSelector()));
        select.selectByVisibleText(size);
        waitForElementToHaveText(sizeLabel(), size);
    }

    public void increaseQuantityBy(int quantity) {
        for (int i = 0; i < quantity; i++) {
            waitUntilElementIsClickable(quantityIncreaseBtn());
            getDriver().findElement(quantityIncreaseBtn()).click();
        }
    }

    public void setQuantity(String quantity) {
        waitUntilElementIsVisible(quantityInput());
        WebElement quantityInput = getDriver().findElement(quantityInput());
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
    }

    public void addItemToCart() {
        waitUntilElementIsClickable(addToCartBtn());
        getDriver().findElement(addToCartBtn()).click();
    }

    public void proceedToCart() {
        waitUntilElementIsVisible(proceedToCheckoutBtn());
        getDriver().findElement(proceedToCheckoutBtn()).click();
    }

    public void clickContinueShoppingBtn() {
        waitUntilElementIsVisible(continueShoppingBtn());
        getDriver().findElement(continueShoppingBtn()).click();
    }

    public void clickHomeLink() {
        waitUntilElementIsClickable(homeLink());
        getDriver().findElement(homeLink()).click();
    }

    public void clickAddToWishlist() {
        waitUntilElementIsClickable(addToWishlist());
        getDriver().findElement(addToWishlist()).click();
    }

    public void clickMyWishlistBtn() {
        waitUntilElementIsClickable(myWishlistBtn());
        getDriver().findElement(myWishlistBtn()).click();
    }
 }
