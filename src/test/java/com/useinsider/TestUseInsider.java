package com.useinsider;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestUseInsider extends EpicUseInsider {

    private static final String CAREER = "CAREER";
    private static final String OFFICE = "Istanbul, Turkey";
    private static final String DEPARTMENT = "Quality Assurance";
    private static final String JOB_POSITION = "Quality Assurance Tester";

    @Test
    public void testScenario(){
        checkHomePage();
        homePage.selectTopMenuItem(CAREER);
        checkBlocksArePresentOnCareerPage();
        careerPage.scrollToCareerOpportunities();
        selectByOfficesAndDepartments(OFFICE, DEPARTMENT);
        verifyJobsList(DEPARTMENT, OFFICE);
        careerPage.selectJobPosition(JOB_POSITION);
        checkCorrectJobPageIsOpened(JOB_POSITION);
        jobDescriptionPage.clickApplyButton();
        checkSubmitYourAppFormOpened();
    }
}
