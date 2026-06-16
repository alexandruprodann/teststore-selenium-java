package Utilities;

import org.testng.Reporter;

import java.util.Arrays;

public class TestConstants {

    // URLs
    public static final String BASE_URL = "https://teststore.automationtesting.co.uk/index.php";
    public static final String LOGIN_URL = BASE_URL + "?controller=authentication";
    public static final String MY_WISHLISTS_URL = BASE_URL + "?fc=module&module=blockwishlist&controller=lists";
    public static final String SITEMAP_URL = BASE_URL + "?controller=sitemap";

    // Account
    public static final String DESKTOP_TEST_EMAIL = getRequiredEnv("DESKTOP_TEST_EMAIL");
    public static final String DESKTOP_TEST_PASSWORD = getRequiredEnv("DESKTOP_TEST_PASSWORD");
    public static final String MOBILE_TEST_EMAIL = getRequiredEnv("MOBILE_TEST_EMAIL");
    public static final String MOBILE_TEST_PASSWORD = getRequiredEnv("MOBILE_TEST_PASSWORD");
    public static final String BIRTHDAY = "01/01/2001";

    // Order Details
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String ADDRESS = "777 Dummy Address";
    public static final String CITY = "Los Dummy";
    public static final String POSTAL_CODE = "00000";

    // Promo Code
    public static final String PROMOCODE_TWENTY = "20OFF";

    // Products
    public static final String PRINTED_SWEATER = "Hummingbird printed sweater";

    public static String getTestEmail() {
        return isMobileTest() ? MOBILE_TEST_EMAIL : DESKTOP_TEST_EMAIL;
    }

    public static String getTestPassword() {
        return isMobileTest() ? MOBILE_TEST_PASSWORD : DESKTOP_TEST_PASSWORD;
    }

    private static String getRequiredEnv(String envName) {
        String value = System.getenv(envName);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable: " + envName);
        }

        return value;
    }

    private static boolean isMobileTest() {
        try {
            return Arrays.asList(Reporter.getCurrentTestResult().getMethod().getGroups()).contains(Platform.MOBILE);
        } catch (Exception e) {
            return false;
        }
    }
}
