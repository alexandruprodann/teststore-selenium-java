package Utilities;

import org.openqa.selenium.By;

import static Utilities.BaseClass.isMobile;

public class LocatorFactory {

    public enum LocatorType {
        CSS_SELECTOR,
        XPATH,
        ID,
        NAME,
        TAG_NAME,
        LINK_TEXT,
        PARTIAL_LINK_TEXT,
        CLASS_NAME
    }

    /**
     * Returns locator based on platform
     *
     * @param locatorType The type of locator
     * @param desktop Locator for desktop
     * @param mobile Locator for mobile
     * @return By locator for the appropriate platform
     */
    public static By createLocator(LocatorType locatorType, String desktop, String mobile) {
        String locator = isMobile() ? mobile : desktop;
        return createLocatorHelper(locatorType, locator);
    }

    // Overloaded method
    public static By createLocator(LocatorType locatorType, String locator) {
        return createLocatorHelper(locatorType, locator);
    }

    // Helper method
    private static By createLocatorHelper(LocatorType locatorType, String locator) {
        return switch (locatorType) {
            case CSS_SELECTOR -> By.cssSelector(locator);
            case ID -> By.id(locator);
            case XPATH -> By.xpath(locator);
            case NAME -> By.name(locator);
            case TAG_NAME -> By.tagName(locator);
            case LINK_TEXT -> By.linkText(locator);
            case PARTIAL_LINK_TEXT -> By.partialLinkText(locator);
            case CLASS_NAME -> By.className(locator);
        };
    }
}
