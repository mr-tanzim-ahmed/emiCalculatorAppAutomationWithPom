# EMI Calculator App Automation

This repository is a Java/Appium scaffold for automating the Android [EMI Calculator app](https://play.google.com/store/apps/details?id=com.continuum.emi.calculator) (the original project notes app version 2.0.9). It uses the Page Object Model (POM) to organize screen interactions.

> **Project status:** The repository currently contains the base screen abstractions and a TestNG suite descriptor. It does not yet include test cases, app/device capabilities, driver setup, or report-generation code. The regression suite currently points to a test package that is not present.

## Technology

- Java
- Gradle 8.14 (wrapper)
- Appium Java Client 9.5.0 and Selenium 4.34.0
- TestNG 7.11.0
- ExtentReports 5.1.1, Commons IO 2.14.0, and Commons Codec 1.15.0 are declared test dependencies; reporting and related utilities are not implemented yet.

## Requirements

- JDK 11 or later
- Android device or emulator and the app under test for future device-driven tests
- Appium Server for future device-driven tests

The current source does not start an Appium server, install the app, or configure a device. Those steps must be implemented/configured before tests can interact with a device.

## Build and test

From the repository root, run the Gradle wrapper:

```powershell
.\gradlew.bat test
```

On macOS or Linux, use:

```bash
./gradlew test
```

Gradle is configured to use TestNG. There are currently no test classes, so this command builds the project but does not execute application tests.

## Project layout

```text
src/
└── test/
    ├── java/com/continuum/emi/calculator/
    │   ├── screens/
    │   │   ├── BaseScreen.java
    │   │   └── Screen.java
    │   └── util/
    │       └── AppiumUtil.java
    └── resources/
        └── regressionSuites.xml
```

- `Screen` holds the shared Android driver and a 30-second explicit wait, and defines the screen interaction contract.
- `BaseScreen` provides basic element lookup, text, click, and wait operations.
- `AppiumUtil` contains the shared wait-time constant.
- `regressionSuites.xml` is a TestNG suite descriptor targeting `com.continuum.emi.calculator.testCase`; create that package and its tests before expecting the suite to run tests.

## Adding tests

Add test classes under `src/test/java/com/continuum/emi/calculator/`, implement the Appium driver and device configuration required by your environment, and build page objects under `screens/`. Update `regressionSuites.xml` to match the test packages when adding tests. Configure reporting separately if ExtentReports output is required.
