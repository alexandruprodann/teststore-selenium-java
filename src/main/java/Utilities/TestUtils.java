package Utilities;

public class TestUtils {

    public static String generateRandomEmail() {
        return generateRandomString() + "@test.com";
    }

    public static String generateRandomString() {
        final String letterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder s = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int ch = (int) (letterString.length() * Math.random());
            s.append(letterString.charAt(ch));
        }

        return s.toString();
    }
}
