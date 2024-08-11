package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    // Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Locate elements using @FindBy annotation
    @FindBy(css = "#group_1")
    private WebElement sizeSelector;

    @FindBy(css = ".bootstrap-touchspin-up")
    private WebElement quantityIncreaseBtn;

    @FindBy(css = ".bootstrap-touchspin-up")
    private WebElement quantityDecreaseBtn;

    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = "div:nth-of-type(1) > .control-label")
    private WebElement sizeLabel;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(linkText = "Home")
    private WebElement homeLink;

    // Modal buttons
    @FindBy(css = ".modal-body .btn.btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".modal-body .btn.btn-secondary")
    private WebElement continueShoppingBtn;

    /*
     *
     * Actions
     *
     * */
    public void selectSize(String size) {
        waitForClickable(sizeSelector);
        Select select = new Select(sizeSelector);
        select.selectByVisibleText(size);
        waitForElementToHaveText(sizeLabel, size);
    }

    public void increaseQuantity(int quantity) {
        for (int i = 0; i < quantity; i++) {
            waitForClickable(quantityIncreaseBtn);
            quantityIncreaseBtn.click();
        }
    }

    public void setQuantity(String quantity) {
        waitForVisibility(quantityInput);
        quantityInput.click();
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys(quantity);
    }

    public void addItemToCart() {
        waitForClickable(addToCartBtn);
        addToCartBtn.click();
    }

    public void proceedToCart() {
        waitForVisibility(proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
    }

    public void clickContinueShoppingBtn() {
        waitForVisibility(continueShoppingBtn);
        continueShoppingBtn.click();
    }

    public void clickHomeLink() {
        waitForClickable(homeLink);
        homeLink.click();
    }
 }
