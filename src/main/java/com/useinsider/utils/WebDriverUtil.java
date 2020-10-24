package com.useinsider.utils;

import com.google.common.base.Stopwatch;
import net.serenitybdd.core.time.InternalSystemClock;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import static java.lang.System.lineSeparator;
import static org.apache.commons.lang3.BooleanUtils.toBoolean;

public class WebDriverUtil {

    private static WebDriver driver = null;
    private static String userDir = System.getProperty("user.dir");
    private static final String ASYNC_REQUESTS_FINISHED = new StringJoiner(lineSeparator())
            .add("return (")
            .add("(typeof jQuery !== 'undefined') ")
            .add("&& (jQuery.active <= 0) ")
            .add("&& (document.readyState == 'complete')")
            .add(");").toString();

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver createInstance(String browserName){
        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", userDir + "\\drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", userDir + "\\drivers\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
        }
        return driver;

    }

    public static void waitSilently(final BooleanSupplier suppliedCondition, final long waitTimeout,
                                    final long waitInterval) {
        final Stopwatch waitTimer = Stopwatch.createStarted();
        for (long secs = 0; secs <= waitTimeout; secs += waitInterval) {
            waitABit(waitInterval);
            if (suppliedCondition.getAsBoolean() || (waitTimer.elapsed(TimeUnit.MILLISECONDS) > waitTimeout)) {
                break;
            }
        }
    }

    public static void waitABit(final long timeInMilliseconds) {
        new InternalSystemClock().pauseFor(timeInMilliseconds);
    }

    public static void waitForAsyncExecution() {
        waitSilently(
                () -> toBoolean(((JavascriptExecutor) getDriver()).executeScript(ASYNC_REQUESTS_FINISHED).toString()),
                3000, 500
        );
    }
}
