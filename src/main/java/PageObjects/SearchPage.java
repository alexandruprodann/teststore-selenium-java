package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage extends BaseClass {

    public enum DropdownOptions {
        PRICE_LOW_TO_HIGH("Price, low to high"),
        PRICE_HIGH_TO_LOW("Price, high to low"),
        NAME_A_TO_Z("Name, A to Z"),
        NAME_Z_TO_A("Name, Z to A");

        private final String option;

        DropdownOptions(String option) {
            this.option = option;
        }

        public String getName() {
            return option;
        }
    }


    // Elements
    private By productTitle() {
        return By.cssSelector(".product-title");
    }

    private By sortByDropdown() {
        return By.cssSelector(".sort-by-row button");
    }

    private By dropdownOption(String optionName) {
        return By.xpath(String.format("//a[normalize-space()='%s']", optionName));
    }

    private By productPrice() {
        return By.cssSelector(".product-price-and-shipping .price");
    }

    private By loadingIcon() {
        return By.cssSelector("#auto-clicker-autofill-popup-tr");
    }

    public By productSearchNoMatches() {
        return By.cssSelector("#product-search-no-matches");
    }

    public By paginationControls() {
        return By.cssSelector(".page-list");
    }

    private By nextPage() {
        return By.cssSelector(".next.js-search-link");
    }


    // Actions
    public boolean searchResultsDisplayedBool() {
        return getDriver().findElement(productTitle()).isDisplayed();
    }

    public String getProductTitleText() {
        return getDriver().findElement(productTitle()).getText();
    }

    public void clickSortByDropdownBtn() {
        waitUntilElementIsClickable(sortByDropdown());
        getDriver().findElement(sortByDropdown()).click();
    }

    public void clickDropdownOption(DropdownOptions option) {
        waitUntilElementIsVisible(dropdownOption(option.getName()));
        getDriver().findElement(dropdownOption(option.getName())).click();
    }

    public void sortBy(DropdownOptions option) {
        clickSortByDropdownBtn();
        clickDropdownOption(option);
    }

    public void clickNext() {
        waitUntilElementIsClickable(nextPage());
        getDriver().findElement(nextPage()).click();
    }

    public List<WebElement> getListOfPrices() {
        return getDriver().findElements(productPrice());
    }

    public boolean areItemsSortedByPrice(String order) {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<WebElement> listOfPrices = getListOfPrices();
        double firstPrice = Double.parseDouble(listOfPrices.getFirst().getText().replace("$", ""));
        double lastPrice = Double.parseDouble(listOfPrices.getLast().getText().replace("$", ""));

        if (order.equalsIgnoreCase("ascending")) {
            return firstPrice < lastPrice;
        } else if (order.equalsIgnoreCase("descending")) {
            return firstPrice > lastPrice;
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }
    }

    public boolean areItemsSortedByName(String order) {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<WebElement> productTitlesList = getDriver().findElements(productTitle());
        ArrayList<String> titles = new ArrayList<>();

        for (WebElement title : productTitlesList) {
            titles.add(title.getText());
        }

        List<String> sortedTitles = new ArrayList<>(titles);
        if (order.equalsIgnoreCase("AtoZ")) {
            Collections.sort(sortedTitles);
        } else if (order.equalsIgnoreCase("ZtoA")){
            Collections.sort(sortedTitles.reversed());
        } else {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }

        return titles.equals(sortedTitles);
    }
}
