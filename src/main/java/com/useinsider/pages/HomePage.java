package com.useinsider.pages;

import com.useinsider.core.AbstractPage;
import com.useinsider.utils.WebDriverUtil;


public class HomePage extends AbstractPage {

    private static final String MENU_ITEM = "//header//ul[@class='ubermenu-nav']//li//span[text()='%s']";
    private static final String LOGO = "//a[@id='logo']";



    public void selectTopMenuItem(final String item){
       findBy(String.format(MENU_ITEM, item)).click();
    }

    public void openHomePage(){
        WebDriverUtil.getDriver().get("https://useinsider.com/");
    }

    public boolean checkLogoIsPresent(){
        return isElementPresent(LOGO);
    }
}
