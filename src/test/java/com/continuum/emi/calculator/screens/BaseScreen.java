package com.continuum.emi.calculator.screens;

import com.aventstack.extentreports.Status;
import com.continuum.emi.calculator.report.ReportTestManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseScreen extends Screen{
    public BaseScreen(AndroidDriver driver){
        super(driver);
    }

    @Override
    public WebElement getAppElement(By locator) {
        WebElement element =null;
        try {
            addInfo("Appium AndroidDriver going to find a Element With "+locator+" locator");
            element = driver.findElement(locator);
            addInfo("Appium AndroidDriver found a App Element with " + locator + " Locator");
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            addFailInfo("Appium AndroidDriver is not found a App Element with " + locator + " Locator");
            System.out.println("Element not found: "+locator);
        }
        return element;
    }

    @Override
    public List<WebElement> getAppElements(By locator) {
        List<WebElement> elements = null;
        try{
            addInfo("Appium AndroidDriver going to find Elements With "+locator+" locator");
            elements = driver.findElements(locator);
            addInfo("Appium AndroidDriver found App Elements with " + locator + " Locator");
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            addFailInfo("Appium AndroidDriver is not found App Elements with " + locator + " Locator");
            System.out.println("Elements not found: "+locator);
        }
        return elements;
    }
    @Override
    public String getAppElementText(By locator){
        return getAppElement(locator).getText();
    }
    @Override
    public void tapAppElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Override
    public void setWait(By locator) {
        wait.until(ExpectedConditions.visibilityOf(getAppElement(locator)));
    }
    public void addInfo(String message){
        if(ReportTestManager.getTest() != null){
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
    public void addFailInfo(String message){
        if(ReportTestManager.getTest() != null){
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }

}
