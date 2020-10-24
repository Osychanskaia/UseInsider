package com.useinsider.core;

import com.useinsider.utils.WebDriverUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import static com.useinsider.utils.WebDriverUtil.getDriver;


public abstract class AbstractTest {

    public void screenshotFailure(String filename) throws IOException {
        File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        File targetFile = new File ("c:\\tmp\\screenshot.png");
        FileUtils.copyFile (srcFile, targetFile);
    }



    @BeforeTest()
    public void setUp() {
        WebDriverUtil.createInstance("chrome");
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result) throws IOException {
        if(result.FAILURE == result.getStatus()) {
            screenshotFailure(result.getName());
        }
    }
}
