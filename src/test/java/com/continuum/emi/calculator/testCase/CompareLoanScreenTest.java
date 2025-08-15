package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.CompareLoanScreen;
import com.continuum.emi.calculator.screens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoanScreenTest extends BaseTest{
    CompareLoanScreen loanScreen;
    @Test(priority = 0)
    public void checkCompareLoanScreenTitle(){
        loanScreen = screen.goTo(LandingScreen.class)
                .tapCompareLoans();
        Assert.assertEquals(loanScreen.compareLoanScreenTitle(),"Compare Loans");
    }
    @Test(priority = 1)
    public void compareLoanScreenShouldSucceed(){
        loanScreen = screen.goTo(CompareLoanScreen.class)
                .fillLoan1Amount(200)
                .fillLoan2Amount(220)
                .fillLoan1InterestRate(5)
                .fillLoan2InterestRate(6)
                .fillLoan1Months(10)
                .fillLoan2Months(12)
                .tapCalculateButton();
        Assert.assertTrue(loanScreen.isCalculatedDataDisplayed(), "Comparison Table displayed");
    }
    @Test(priority = 2)
    public void resetLoanScreenShouldSucceed(){
        loanScreen = loanScreen.tapResetButton();
        Assert.assertFalse(loanScreen.isCalculatedDataDisplayed(),"Reset Button Working");
    }

}
