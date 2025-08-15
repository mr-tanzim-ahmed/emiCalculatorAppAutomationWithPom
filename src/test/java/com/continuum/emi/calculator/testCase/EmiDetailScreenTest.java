package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.EmiDetailScreen;
import com.continuum.emi.calculator.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiDetailScreenTest extends BaseTest{
    EmiDetailScreen detailScreen;

    @Test
    public void emiDetailScreenSucceed(){
        detailScreen = screen.goTo(LandingScreen.class)
                .tapEmiCalculatorButton()
                .enterLoanAmount(1000)
                .enterInterestRate(10)
                .enterYears(1)
                .enterMonths(4)
                .enterProcessingFeeRate(5)
                .tapCalculateButton()
                .tapDetailButton();
        Assert.assertTrue(detailScreen.isEmiDetailScreenDisplayed(),"Emi Details displayed");
    }

}