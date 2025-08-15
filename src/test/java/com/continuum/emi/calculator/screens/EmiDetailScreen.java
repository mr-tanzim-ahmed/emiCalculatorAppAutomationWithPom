package com.continuum.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiDetailScreen extends BaseScreen {

    public EmiDetailScreen(AndroidDriver driver) {

        super(driver);
    }

    public boolean isEmiDetailScreenDisplayed() {
        setWait(By.id("layoutDetailContainer"));
        return getAppElements(By.id("layoutDetailContainer")).size() > 0;
    }

    public boolean isEmiMonthlyListDisplayed() {
        setWait(By.id("detailListView"));
        return getAppElements(By.id("detailListView")).size() > 0;
    }

}
