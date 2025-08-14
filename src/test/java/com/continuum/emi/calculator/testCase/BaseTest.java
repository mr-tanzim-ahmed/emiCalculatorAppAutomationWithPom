package com.continuum.emi.calculator.testCase;

import com.continuum.emi.calculator.screens.BaseScreen;
import com.continuum.emi.calculator.screens.Screen;
import com.continuum.emi.calculator.util.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.apache.commons.codec.binary.Base64;

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

        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos/";
        File theDir = new File(destinationPath);
        if(!theDir.exists()){
            theDir.mkdir();
        }
        String filePath = destinationPath+"/"+driver.getDeviceTime().replace(":","_").replace("+"," ")+".mp4";
        System.out.println("filePath : "+filePath);
        Path path = Paths.get(filePath);
        try{
            Files.write(path,data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void takeScreenshot(){
        try {
            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir")+"build/screenshots/";
            FileUtils.copyFile(srcFile, new File(currentDir+ System.currentTimeMillis()+".png"));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public AndroidDriver getAndroidDriver(){
        return driver;
    }
}
