package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;

public class FilterPage extends BaseClass {

    // Elements
    private By filterOption(String optionName) {
        return By.xpath(String.format("//a[contains(text(),'%s')]", optionName));
    }

    private By filterBtnMob() {
        return By.cssSelector("#search_filter_toggler");
    }

    private By filterCategoryMob(String filterCategory) {
        return By.xpath(String.format("//p[@class='h6 facet-title'][text()='%s']", filterCategory));
    }

    private By okBtnMob() {
        return By.cssSelector(".btn.btn-secondary.ok");
    }

    public By filterBlock() {
        return By.cssSelector(".filter-block");
    }


    // Actions
    public void filterBy(String filterCategory, String filter) {
        if (isMobile()) {
            clickFilterBtnMob();
            clickFilterCategoryMob(filterCategory);
            waitUntilElementIsClickable(filterOption(filter));
            jsClick(filterOption(filter));
            clickOkBtnMob();
        } else {
            waitUntilElementIsClickable(filterOption(filter));
            getDriver().findElement(filterOption(filter)).click();
        }
    }

    public void clickFilterBtnMob() {
        waitUntilElementIsClickable(filterBtnMob());
        getDriver().findElement(filterBtnMob()).click();
    }

    public void clickFilterCategoryMob(String filterCategory) {
        waitUntilElementIsClickable(filterCategoryMob(filterCategory));
        getDriver().findElement(filterCategoryMob(filterCategory)).click();
    }

    public void clickOkBtnMob() {
        scrollToElementCenter(okBtnMob());
        waitUntilElementIsClickable(okBtnMob());
        getDriver().findElement(okBtnMob()).click();
    }

}
