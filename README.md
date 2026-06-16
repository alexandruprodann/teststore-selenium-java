# 🧪 Test Store - Selenium Java Automation Framework

![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-Test_Framework-red)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI-blue)

## 📌 Overview

This project contains end-to-end automated tests for the [Test Store website](https://teststore.automationtesting.co.uk/index.php).

The framework is built with **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model** design pattern.

It covers both **desktop** and **mobile viewport** scenarios, including authentication, cart actions, checkout flows, sorting, filtering, forms, links, and user account features.

---

## ✅ Test Coverage

The automated suite includes tests for:

* 📝 **Sign-Up** - verifies that guests can register successfully.
* 🔐 **Login** - verifies that existing users can log in successfully.
* 🚫 **Invalid Login** - verifies that users cannot log in with invalid credentials.
* 🛒 **Guest Checkout** - verifies that guest users can complete an order.
* 👤 **Logged-In Checkout** - verifies that authenticated users can complete an order.
* ❌ **Remove Item From Cart** - verifies that products can be removed from the cart.
* ❤️ **Wishlist** - verifies that logged-in users can add products to their wishlist.
* ↕️ **Sort by Price** - verifies that products are sorted correctly by price.
* 🔎 **Search, filtering, pagination, forms, profile, and order-history scenarios**.
* 🔗 **Link validation** for desktop flows.

---

## 🛠️ Tech Stack

* **Java 21**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **ChromeDriver**
* **GitHub Actions**
* **IntelliJ IDEA**

---

## 🔐 Environment Variables

The test suite requires separate desktop and mobile test accounts.
This prevents parallel runs from modifying the same user data.

Set the following environment variables locally or configure them as **GitHub Actions repository secrets**:

```bash
DESKTOP_TEST_EMAIL=
DESKTOP_TEST_PASSWORD=
MOBILE_TEST_EMAIL=
MOBILE_TEST_PASSWORD=
```

Both accounts should be valid Test Store users.

Some logged-in checkout and order-history tests expect the accounts to already have:

* a saved address
* existing order history

Do not commit real credentials to the repository.

---

## 📁 Project Structure

```text
teststore-selenium-java
├── PageObjects/          # Page Object Model classes
├── Tests/                # Desktop and mobile TestNG test classes
│   ├── Desktop/          # Desktop test scenarios
│   └── Mobile/           # Mobile viewport test scenarios
├── Utilities/            # Driver setup, waits, constants, helpers, and shared utilities
├── testng.xml            # Default local TestNG suite
├── pom.xml               # Maven build and dependencies
└── .github/workflows/    # GitHub Actions CI workflow
```

---

## ▶️ Running Tests Locally

### Run from IntelliJ IDEA

Open the project in IntelliJ IDEA and run:

```text
testng.xml
```

### Run from terminal

Using Maven:

```bash
mvn test
```

Using the Maven wrapper:

```bash
./mvnw test
```

On Windows:

```bash
mvnw.cmd test
```

---

## ⚙️ GitHub Actions CI

The project includes a GitHub Actions workflow for running the Selenium suite in CI.

The workflow supports manual runs with configurable options:

* **platform**: `all`, `desktop`, `mobile`
* **feature**: `all`, `auth`, `cart`, `filter`, `forms`, `linkvalidator`, `order`, `product`, `search`, `sort`, `user`
* **thread_count**: `1`, `2`, `3`, `4`

CI runs always execute in **headless mode**.

For push and pull request runs, the workflow executes the default full suite:

* all platforms
* all features
* headless browser mode
* default thread count

The workflow also uploads useful artifacts, including:

* generated CI TestNG XML
* Surefire/TestNG reports
* failure screenshots

---

## 🧪 Test Execution Notes

The framework uses TestNG groups and dynamically generated suite files in CI to control which tests are executed.

Desktop and mobile tests use separate configured accounts to avoid data conflicts during parallel execution.

The `linkvalidator` feature exists only under desktop tests, so selecting `mobile + linkvalidator` is intentionally blocked by the CI workflow.

---

## 🚀 Goal of the Project

This project demonstrates a maintainable Selenium automation framework with:

* Page Object Model structure
* reusable utilities
* desktop and mobile test coverage
* CI execution through GitHub Actions
* environment-based test accounts
* configurable TestNG execution

The goal is to keep the framework clear, practical, and easy to extend with new automated test scenarios.
