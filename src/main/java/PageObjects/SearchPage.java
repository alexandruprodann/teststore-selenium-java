package PageObjects;

import Utilities.BaseClass;
import Utilities.LocatorFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utilities.LocatorFactory.LocatorType.CSS_SELECTOR;
import static Utilities.LocatorFactory.LocatorType.XPATH;

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
        return LocatorFactory.createLocator(CSS_SELECTOR, ".product-title");
    }

    private By sortByDropdown() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".sort-by-row button");
    }

    private By dropdownOption(String optionName) {
        return LocatorFactory.createLocator(XPATH, String.format("//a[normalize-space()='%s']", optionName));
    }

    private By productPrice() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".product-price-and-shipping .price");
    }

    private By loadingIcon() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#auto-clicker-autofill-popup-tr");
    }

    public By productSearchNoMatches() {
        return LocatorFactory.createLocator(CSS_SELECTOR, "#product-search-no-matches");
    }

    public By paginationControls() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".page-list");
    }

    private By nextPage() {
        return LocatorFactory.createLocator(CSS_SELECTOR, ".next.js-search-link");
    }


    // Actions
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
