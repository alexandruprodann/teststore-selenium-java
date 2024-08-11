package Utilities;

import java.util.UUID;

public class TestUtils {

    // Method to generate a random email
    public static String generateRandomEmail() {
        String randomString = UUID.randomUUID().toString().replace("-", "");
        return randomString + "@test.com";
    }
}
