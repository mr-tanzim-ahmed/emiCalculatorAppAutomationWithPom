package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LandingScreen extends BaseScreen {

    public LandingScreen(AndroidDriver driver) {
        super(driver);
    }

    public String appTitle() {
        return getAppElementText(By.xpath("//android.widget.TextView[@resource-id=\"com.continuum.emi.calculator:id/appName\" and @text=\"EMI Calculator\"]")).trim();
    }

    public boolean hasPolicyButton() {
        setWait(By.id("policyBtn"));
        return getAppElements(By.id("policyBtn")).size() > 0;
    }

    public boolean hasEmiCalculatorButton() {
        setWait(By.id("btnStart"));
        return getAppElements(By.id("btnStart")).size() > 0;
    }

    public EmiCalculatorScreen tapEmiCalculatorButton() {
        tapAppElement(By.id("btnStart"));
        return goTo(EmiCalculatorScreen.class);
    }

    public boolean hasCompareLoanButton() {
        setWait(By.id("btnCompare"));
        return getAppElements(By.id("btnCompare")).size() > 0;
    }

    public CompareLoanScreen tapCompareLoans() {
        tapAppElement(By.id("btnCompare"));
        return goTo(CompareLoanScreen.class);
    }

    public boolean hasAppsAdSection() {
        return getAppElements(By.id("recycler_view")).size() > 0;
    }

    public boolean hasAdSection() {
        return getAppElements(By.id("adView")).size() > 0;
    }

}
