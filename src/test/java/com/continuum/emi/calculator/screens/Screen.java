package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.continuum.emi.calculator.util.AppiumUtil.WAIT_TIME;

public abstract class Screen {
    AndroidDriver driver;
    WebDriverWait wait;

    public Screen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
    }

    public abstract WebElement getElement(By locator);

    public abstract List<WebElement> getElements(By locator);

    public abstract void tapElement(By locator);

    public abstract String getElementText(By locator);

    public abstract void setWait(By locator);

    public <T extends BaseScreen> T goTo(Class<T> baseScreen) {
        try {
            return baseScreen.getDeclaredConstructor(AndroidDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
