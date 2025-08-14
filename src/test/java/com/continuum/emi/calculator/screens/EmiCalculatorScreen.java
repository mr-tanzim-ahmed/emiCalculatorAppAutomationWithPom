package com.continuum.emi.calculator.screens;

import io.appium.java_client.ExecutesMethod;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiCalculatorScreen extends BaseScreen {

    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public String emiCalculatorScreenTitle() {
        return getElementText(By.xpath("//android.widget.TextView[@text=\"Calculator\"]")).trim();
    }

    public EmiCalculatorScreen enterLoanAmount(int amount) {
        setWait(By.id("etLoanAmount"));
        getElement(By.id("etLoanAmount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public EmiCalculatorScreen enterInterestRate(int rate) {
        getElement(By.id("etInterest")).sendKeys(String.valueOf(rate));
        return this;
    }

    public EmiCalculatorScreen enterYears(int years) {
        getElement(By.id("etYears")).sendKeys(String.valueOf(years));
        return this;
    }

    public EmiCalculatorScreen enterMonths(int months) {
        getElement(By.id("etMonths")).sendKeys(String.valueOf(months));
        return this;
    }

    public EmiCalculatorScreen enterProcessingFeeRate(int rate) {
        getElement(By.id("etFee")).sendKeys(String.valueOf(rate));
        return this;
    }

    public boolean hasCalculateButton() {
        return getElements(By.id("btnCalculate")).size() > 0;
    }

    public EmiCalculatorScreen tapCalculateButton() {
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public boolean hasResetButton() {
        return getElements(By.id("btnReset")).size() > 0;
    }

    public EmiCalculatorScreen tapResetButton() {
        tapElement(By.id("btnReset"));
        return this;
    }

    public boolean hasDetailButton() {
        return getElements(By.id("btnDetail")).size() > 0;
    }

    public EmiDetailScreen tapDetailButton() {
        tapElement(By.id("btnDetail"));
        return goTo(EmiDetailScreen.class);
    }

}
