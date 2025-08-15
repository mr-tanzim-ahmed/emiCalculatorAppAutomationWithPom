# EMI Calculator Automation Test
- App link(https://play.google.com/store/apps/details?id=com.continuum.emi.calculator)
- Version 2.0.9
  
- Language: Java 
- Automation Framework: Appium, Selenium 
- Testing Framework: TestNG
- Reporting Framework:Extent Reporting
- Base64 decodingr library: Commons codec
- Locator: Appium Inspector 
- Device: Genymotion (VM)
- Design Pattern: POM


#File Structure:
<pre><code>
src
    └── test
        ├── java
            └── com
            │   └── continuum
            │       └── emi
            │           └── calculator
            │               ├── report
            │                   ├── ReportManager.java
            │                   ├── ReportTestManager.java
            │                   └── TestListener.java
            │               ├── screens
            │                   ├── BaseScreen.java
            │                   ├── CompareLoanScreen.java
            │                   ├── EmiCalculatorScreen.java
            │                   ├── EmiDetailScreen.java
            │                   ├── LandingScreen.java
            │                   └── Screen.java
            │               ├── testCase
            │                   ├── BaseTest.java
            │                   ├── CompareLoanScreenTest.java
            │                   ├── EmiCalculatorScreenTest.java
            │                   ├── EmiDetailScreenTest.java
            │                   └── LandingScreenTest.java
            │               └── util
            │                   └── AppiumUtil.java
        └── resources
            └── regressionSuites.xml
</code></pre>
