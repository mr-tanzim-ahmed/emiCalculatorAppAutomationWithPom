package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CompareLoanScreen extends BaseScreen {
    public CompareLoanScreen(AndroidDriver driver) {
        super(driver);
    }

    public String compareLoanScreenTitle() {
        return getAppElementText(By.xpath("//android.widget.TextView[@text=\"Compare Loans\"]")).trim();
    }

    public CompareLoanScreen fillLoan1Amount(int amount) {
        setWait(By.id("etLoanAmount1"));
        getAppElement(By.id("etLoanAmount1")).sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillLoan2Amount(int amount) {
        setWait(By.id("etLoanAmount2"));
        getAppElement(By.id("etLoanAmount2")).sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillLoan1InterestRate(int rate) {
        getAppElement(By.id("etInterest1")).sendKeys(String.valueOf(rate));
        return this;
    }

    public CompareLoanScreen fillLoan2InterestRate(int rate) {
        getAppElement(By.id("etInterest2")).sendKeys(String.valueOf(rate));
        return this;
    }

    public CompareLoanScreen fillLoan1Months(int months) {
        getAppElement(By.id("etPeriod1")).sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanScreen fillLoan2Months(int months) {
        getAppElement(By.id("etPeriod2")).sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanScreen tapCalculateButton() {
        tapAppElement(By.id("btnCalculate"));
        return this;
    }

    public CompareLoanScreen tapResetButton() {
        tapAppElement(By.id("btnReset"));
        return this;
    }

    public boolean isCalculatedDataDisplayed() {
        return getAppElements(By.id("layoutTable")).size() > 0;
    }
}
