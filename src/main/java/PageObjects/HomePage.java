package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

    // Constructor
    public HomePage() {
        super();
    }


    // Elements
    private By productItemsListBy() {
        return By.cssSelector(".products > div");
    }

    private By searchBarBy() {
        return By.cssSelector(".ui-autocomplete-input");
    }

    private By clothesLinkBy() {
        return By.linkText("CLOTHES");
    }


    // Actions
    public void chooseRandomProduct() {
        List<WebElement> productItemsList = driver.findElements(productItemsListBy());
        int randomProduct = random.nextInt(productItemsList.size());

        WebElement chosenProduct =  productItemsList.get(randomProduct);
        String chosenProductTitle = chosenProduct.getText();

        if (Objects.equals(chosenProductTitle, "Customizable Mug")) {
            chooseRandomProduct();
        }

        chosenProduct.click();
    }

    public void chooseRandomClothing() {
        driver.findElement(clothesLinkBy()).click();
        chooseRandomProduct();
    }

    public void searchSomething(String searchText) {
        waitUntilElementIsVisible(searchBarBy());
        WebElement searchBar = driver.findElement(searchBarBy());
        searchBar.sendKeys(searchText);
        pressEnter(searchBar);
    }

}
