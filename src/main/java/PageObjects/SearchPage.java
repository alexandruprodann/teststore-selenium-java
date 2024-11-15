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
    public By productTitle() {
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


    // Actions
    public boolean searchResultsDisplayedBool() {
        return getDriver().findElement(productTitle()).isDisplayed();
    }

    public String getSearchResultsText() {
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

    public List<WebElement> getListOfPrices() {
        return getDriver().findElements(productPrice());
    }

    public boolean areItemsSortedByDescendingPrice() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<WebElement> listOfPrices = getListOfPrices();
        double firstPrice = Double.parseDouble(listOfPrices.getFirst().getText().replace("$", ""));
        double lastPrice = Double.parseDouble(listOfPrices.getLast().getText().replace("$", ""));

        return firstPrice > lastPrice;
    }

    public boolean areItemsSortedByAscendingPrice() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<WebElement> listOfPrices = getListOfPrices();
        double firstPrice = Double.parseDouble(listOfPrices.getFirst().getText().replace("$", ""));
        double lastPrice = Double.parseDouble(listOfPrices.getLast().getText().replace("$", ""));

        return firstPrice < lastPrice;
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
            System.out.println("Invalid sort order: " + order);
        }

        return titles.equals(sortedTitles);
    }
}
