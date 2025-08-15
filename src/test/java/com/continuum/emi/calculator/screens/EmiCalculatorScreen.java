package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiCalculatorScreen extends BaseScreen {

    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public String emiCalculatorScreenTitle() {
        return getAppElementText(By.xpath("//android.widget.TextView[@text=\"Calculator\"]")).trim();
    }

    public EmiCalculatorScreen enterLoanAmount(int amount) {
        setWait(By.id("etLoanAmount"));
        getAppElement(By.id("etLoanAmount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public EmiCalculatorScreen enterInterestRate(int rate) {
        getAppElement(By.id("etInterest")).sendKeys(String.valueOf(rate));
        return this;
    }

    public EmiCalculatorScreen enterYears(int years) {
        getAppElement(By.id("etYears")).sendKeys(String.valueOf(years));
        return this;
    }

    public EmiCalculatorScreen enterMonths(int months) {
        getAppElement(By.id("etMonths")).sendKeys(String.valueOf(months));
        return this;
    }

    public EmiCalculatorScreen enterProcessingFeeRate(int rate) {
        getAppElement(By.id("etFee")).sendKeys(String.valueOf(rate));
        return this;
    }

    public boolean hasCalculateButton() {
        return getAppElements(By.id("btnCalculate")).size() > 0;
    }

    public EmiCalculatorScreen tapCalculateButton() {
        tapAppElement(By.id("btnCalculate"));
        return this;
    }

    public boolean hasResetButton() {
        return getAppElements(By.id("btnReset")).size() > 0;
    }

    public EmiCalculatorScreen tapResetButton() {
        tapAppElement(By.id("btnReset"));
        return this;
    }

    public boolean hasDetailButton() {
        return getAppElements(By.id("btnDetail")).size() > 0;
    }

    public EmiDetailScreen tapDetailButton() {
        tapAppElement(By.id("btnDetail"));
        return goTo(EmiDetailScreen.class);
    }

}
