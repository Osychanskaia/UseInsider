package com.useinsider.pages;

import com.useinsider.core.AbstractPage;

public class JobDescriptionPage extends AbstractPage {
    private static final String JOB_DESCRIPTION = "//h3[text()='Job Description']/parent::div";
    private static final String REQUIREMENTS = "//h3[text()='Requirements']/parent::div";
    private static final String APPLY_FOR_THIS_JOB_BUTTON = "//a[text()='Apply for this job']";
    private static final String JOB_TITLE = "//div[@class='posting-headline']/h2";


    public String getJobTitle(){
        return findBy(JOB_TITLE).getText();
    }

    public boolean isRequirementsSectionPresent(){
        return isElementPresent(REQUIREMENTS);
    }

    public boolean isDescriptionSectionPresent(){
        return isElementPresent(JOB_DESCRIPTION);
    }

    public boolean isApplyButtonPresent(){
        return isElementPresent(APPLY_FOR_THIS_JOB_BUTTON);
    }

    public void clickApplyButton(){
        clickOnElement(APPLY_FOR_THIS_JOB_BUTTON);
    }



}
