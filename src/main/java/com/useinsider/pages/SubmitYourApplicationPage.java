package com.useinsider.pages;

import com.useinsider.core.AbstractPage;

public class SubmitYourApplicationPage extends AbstractPage {

    private static final String SUBMIT_YOUR_APP = "//div/h4[text()='Submit your application']";
    private static final String SUBMIT_APP_BUTTON = "//button[text()='Submit application']";

    public boolean isSubmitAppButtonPresent(){
        return isElementPresent(SUBMIT_APP_BUTTON);
    }

    public boolean isSubmitYourAppFormPresent(){
        return isElementPresent(SUBMIT_YOUR_APP);
    }

}
