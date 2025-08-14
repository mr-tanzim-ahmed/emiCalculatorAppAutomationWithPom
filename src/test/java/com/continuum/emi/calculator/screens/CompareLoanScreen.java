package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareLoanScreen extends BaseScreen {
    public CompareLoanScreen(AndroidDriver driver) {
        super(driver);
    }

    public String compareLoanScreenTitle() {
        return getElementText(By.xpath("//android.widget.TextView[@text=\"Compare Loans\"]"));
    }

    public CompareLoanScreen fillLoan1Amount(int amount) {
        setWait(By.id("etLoanAmount1"));
        getElement(By.id("etLoanAmount1")).sendKeys(String.valueOf(amount));
        return this;
    }
    public CompareLoanScreen fillLoan2Amount(int amount) {
        setWait(By.id("etLoanAmount2"));
        getElement(By.id("etLoanAmount2")).sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanScreen fillLoan1InterestRate(int rate) {
        getElement(By.id("etInterest1")).sendKeys(String.valueOf(rate));
        return this;
    }
    public CompareLoanScreen fillLoan2InterestRate(int rate) {
        getElement(By.id("etInterest2")).sendKeys(String.valueOf(rate));
        return this;
    }

    public CompareLoanScreen fillLoan1Months(int months){
        getElement(By.id("etPeriod1")).sendKeys(String.valueOf(months));
        return this;
    }
    public CompareLoanScreen fillLoan2Months(int months){
        getElement(By.id("etPeriod2")).sendKeys(String.valueOf(months));
        return this;
    }

    public CompareLoanScreen tapCalculateButton(){
        tapElement(By.id("btnCalculate"));
        return this;
    }

    public CompareLoanScreen tapResetButton(){
        tapElement(By.id("btnReset"));
        return this;
    }
    public boolean isCalculatedDataDisplayed(){
        return getElements(By.id("layoutTable")).size() > 0;
    }
}
