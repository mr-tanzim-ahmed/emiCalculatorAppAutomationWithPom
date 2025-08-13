package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseScreen extends Screen{
    public BaseScreen(AndroidDriver driver){
        super(driver);
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement element =null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            System.out.println("Element not found: "+locator);
        }
        return element;
    }

    @Override
    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = null;
        try{
            elements = driver.findElements(locator);
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            System.out.println("Elements not found: "+locator);
        }
        return elements;
    }
    @Override
    public String getElementText(By locator){
        return getElement(locator).getText();
    }
    @Override
    public void tapElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Override
    public void setWait(By locator) {
        wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }

    @Override
    public void getSelect(By locator) {

    }
}
