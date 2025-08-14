package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LandingScreen extends BaseScreen {

    public LandingScreen(AndroidDriver driver) {
        super(driver);
    }

    public String appTitle() {
        return getElementText(By.xpath("//android.widget.TextView[@resource-id=\"com.continuum.emi.calculator:id/appName\" and @text=\"EMI Calculator\"]")).trim();
    }

    public boolean hasPolicyButton() {
        return getElements(By.id("policyBtn")).size() > 0;
    }

    public boolean hasEmiCalculatorButton() {
        setWait(By.id("btnStart"));
        return getElements(By.id("btnStart")).size() > 0;
    }

    public EmiCalculatorScreen tapEmiCalculatorButton() {
        tapElement(By.id("btnStart"));
        return goTo(EmiCalculatorScreen.class);
    }

    public boolean hasCompareLoanButton() {
        setWait(By.id("btnCompare"));
        return getElements(By.id("btnCompare")).size() > 0;
    }

    public CompareLoanScreen tapCompareLoans() {
        tapElement(By.id("btnCompare"));
        return goTo(CompareLoanScreen.class);
    }

    public boolean hasAppsAdSection() {
        return getElements(By.id("recycler_view")).size() > 0;
    }

    public boolean hasAdSection() {
        return getElements(By.id("adView")).size() > 0;
    }

}
