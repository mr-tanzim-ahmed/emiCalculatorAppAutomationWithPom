package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.BaseScreen;
import com.continuum.emi.calculator.screens.Screen;
import com.continuum.emi.calculator.util.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    AndroidDriver driver;
    WebDriverWait wait;
    Screen screen;
    @BeforeClass
    public void launchAppium(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "192.168.199.102:5555");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:appPackage", "com.continuum.emi.calculator");
        capabilities.setCapability( "appium:appActivity", "com.finance.emicalci.activity.AdActivity");

        try{
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppiumUtil.WAIT_TIME));
            driver.startRecordingScreen();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
        screen = new BaseScreen(driver);
    }

    @AfterClass
    public void closeAppium(){
        recordingVideo();
        driver.quit();
    }
    private void recordingVideo(){

    }
}
