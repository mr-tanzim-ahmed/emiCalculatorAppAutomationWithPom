package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.EmiCalculatorScreen;
import com.continuum.emi.calculator.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingScreenTest extends BaseTest {
    @Test
    public void appTitleTest() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);
        Assert.assertEquals(landingScreen.appTitle(), "EMI Calculator");
    }

    @Test
    public void chackEmiCalculatorButton() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);

        Assert.assertTrue(landingScreen.hasEmiCalculatorButton());
    }

    @Test
    public void emiCalculatorButtonTest() {
        EmiCalculatorScreen emiCalculatorScreen = screen.goTo(LandingScreen.class)
                .tapEmiCalculatorButton();
        Assert.assertEquals(emiCalculatorScreen.emiCalculatorScreenTitle(), "Calculator");
    }

    @Test
    public void checkCompareLoansButton() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);
        Assert.assertTrue(landingScreen.hasCompareLoanButton());
    }

    @Test
    public void policyButtonTest() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);
        Assert.assertTrue(landingScreen.hasPolicyButton());
    }


    @Test
    public void checkAppsAdSection() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);
        Assert.assertTrue(landingScreen.hasAppsAdSection());
    }

    @Test
    public void checkAdSection() {
        LandingScreen landingScreen = screen.goTo(LandingScreen.class);
        Assert.assertTrue(landingScreen.hasAdSection());
    }

}
