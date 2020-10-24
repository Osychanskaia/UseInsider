package com.useinsider.core;

import com.useinsider.utils.WebDriverUtil;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public abstract class AbstractPage extends PageObject {

    protected WebElement findBy(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected WebElement scrollToElementRealization(WebElement element) {
        final int disposition = element.getLocation().getY();
        ((JavascriptExecutor) getDriver()).executeScript(format("window.scroll(0, %d)", disposition));
        return element;
    }

    protected boolean isElementPresent(String xpath){
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return isNotEmpty(getDriver().findElements(By.xpath(xpath)));
    }

    protected void clickOnElement(String xpath){
        findBy(xpath).click();
    }

    public WebDriver getDriver(){
        return WebDriverUtil.getDriver();
    }


}
