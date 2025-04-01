# 🛒 Test Store - Selenium with Java - Personal Project

## 📝 Overview
This project is a personal initiative to automate end-to-end (E2E) testing for a [Test Store website](https://teststore.automationtesting.co.uk/index.php). The tests are developed using Java, Selenium, and Maven, with IntelliJ IDEA as the development environment.

## 💻 Tests
- **Login Test**: Ensures that a user can successfully log in to the Test Store.
- **Order Complete As Guest Test**: Verifies the functionality to complete an order as a guest user.
- **Remove Item From Cart Test**: Tests the ability to remove items from the shopping cart.
- **Sign-Up Test**: Verifies that guests are able to successfully register.
- **Search Bar Test**: Tests that the search bar works and returns correct results.
- **Contact Us Form Test**: Ensures that users can successfully submit the Contact Us form.
- **Add To Wishlist Test**: Check if logged-in users can add items to their wishlist.
- **Sort by Price Test**: Verify that products sort correctly by price, from low to high and high to low.
- **Sort by Name Test**: Check that products sort correctly by name, A to Z and Z to A.
- **Coupon Code Test**: Ensure that applying a valid coupon correctly adjusts the total price.
- **Update Item Quantity Test**: Verify that users can change the quantity of items in their cart.
- **Login with Invalid Credentials Test**: Verify that users are unable to login with invalid credentials.
- _[more to come...]_

## 🛠️ Technologies Used

- **Java 21**: The programming language used for writing the tests.
- **Maven**: For dependency management.
- **Selenium**: The tool used for automating web browser interactions.
- **TestNG**: TestNG: The testing framework used for organizing and running test cases.
- **ChromeDriver**: The WebDriver used to control the Chrome browser.
- **Git**: Version control for managing the project.
- **IntelliJ IDEA**: The IDE used for development.

## 📂 Project Structure

- **PageObjects**: Contains Page Object Model classes representing various pages of the Test Store.
- **Utilities**: Contains utility classes like `TestConstants`.
- **Tests**: Contains the test classes that perform various E2E test scenarios.
- **pom.xml**: Maven configuration file for managing project dependencies.


## 🎯 Conclusion

This project serves as a practice for automating E2E tests in a web application using Selenium and Java. It covers essential user flows like login, placing an order, and managing the shopping cart. The project is maintained as a personal exercise in improving my test automation skills.

