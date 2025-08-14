package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.EmiCalculatorScreen;
import com.continuum.emi.calculator.screens.EmiDetailScreen;
import com.continuum.emi.calculator.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculatorScreenTest extends BaseTest{
    EmiCalculatorScreen calculatorScreen;
     @Test(priority = 0)
    public void emiCalculatorShouldSucceed(){
         calculatorScreen = screen.goTo(LandingScreen.class)
                .tapEmiCalculatorButton()
                .enterLoanAmount(10000)
                .enterInterestRate(10)
                .enterYears(1)
                .enterMonths(6)
                .enterProcessingFeeRate(5)
                .tapCalculateButton();
        //After tapping Calculate button, We see the 'Detail' Button
        Assert.assertTrue(calculatorScreen.hasDetailButton());
    }
    @Test(priority = 1)
    public void resetCalculatorShouldSucceed(){
        calculatorScreen = calculatorScreen.tapResetButton();
        Assert.assertFalse(calculatorScreen.hasDetailButton());
    }
    @Test(priority = 2)
    public void detailsCalculatorShouldSucceed(){
        EmiDetailScreen emiDetailScreen = screen.goTo(EmiCalculatorScreen.class)
                .enterLoanAmount(10000)
                .enterInterestRate(10)
                .enterYears(1)
                .enterMonths(6)
                .enterProcessingFeeRate(5)
                .tapCalculateButton()
                .tapDetailButton();
        //After tapping Calculate button, We see the 'Detail' Button
        Assert.assertTrue(emiDetailScreen.isEmiDetailScreenDisplayed());
    }
}
