package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LandingScreen extends BaseScreen{

    public LandingScreen(AndroidDriver driver) {
        super(driver);
    }
    public String appTitle(){
        return getElementText(By.xpath("//android.widget.TextView[@resource-id=\"com.continuum.emi.calculator:id/appName\" and @text=\"EMI Calculator\"]"));
    }
    public boolean hasPolicyButton() {
        return getElements(By.id("policyBtn")).size() > 0;
    }
    public EmiCalculatorScreen tapEmiCalculator(){
        tapElement(By.id("btnStart"));
        return goTo(EmiCalculatorScreen.class);
    }
    public CompareLoanScreen tapCompareLoans(){
        tapElement(By.id("btnCompare"));
        return goTo(CompareLoanScreen.class);
    }

    public boolean hasAppsAdView(){
        return getElements(By.id("recycler_view")).size() > 0;
    }
    public boolean hasAppsAdSection() {
        return getElements(By.id("adSection")).size() > 0;
    }

    public boolean hasBottomAdView(){
        return getElements(By.id("adView")).size() > 0;
    }

}
