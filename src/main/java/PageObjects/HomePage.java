package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locate elements using @FindBy annotation
    @FindBy(css = ".products > div")
    private List<WebElement> productItems;

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchBar;

    @FindBy(linkText = "CLOTHES")
    private WebElement clothesLink;


    /*
     *
     * Actions
     *
     * */
    public void chooseRandomProduct() {
        int randomProduct = random.nextInt(productItems.size());
        WebElement chosenProduct = productItems.get(randomProduct);
        String chosenProductTitle = chosenProduct.getText();

        if (Objects.equals(chosenProductTitle, "Customizable Mug")) {
            chooseRandomProduct();
        }

        chosenProduct.click();
    }

    public void chooseRandomClothing() {
        clothesLink.click();
        chooseRandomProduct();
    }


    public void searchSomething(String searchText) {
        waitForVisibility(searchBar);
        searchBar.sendKeys(searchText);
        pressEnter(searchBar);
    }


}
