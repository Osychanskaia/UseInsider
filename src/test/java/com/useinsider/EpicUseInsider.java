package com.useinsider;

public class EpicUseInsider extends TestExecutor {

    private static final String CAREER = "CAREER";
    private static final String OFFICE = "Istanbul, Turkey";
    private static final String DEPARTMENT = "Quality Assurance";
    private static final String JOB_POSITION = "Quality Assurance Tester";

    void checkHomePageIsOpened(){
        checkHomePage();
    }

    void verifyAllBlocksArePresentOnCareerPage(){
        homePage.selectTopMenuItem(CAREER);
        checkBlocksArePresentOnCareerPage();
    }

    void checkThatSelectingByOfficeAndDepartmentWorksCorrectly(){
        careerPage.scrollToCareerOpportunities();
        selectByOfficesAndDepartments(OFFICE, DEPARTMENT);
        verifyJobsList(DEPARTMENT, OFFICE);
    }

    void checkCorrectJobPageIsOpenedWhenWeAreSelectingJobPosition(){
        careerPage.selectJobPosition(JOB_POSITION);
        checkCorrectJobPageIsOpened(JOB_POSITION);
    }
    void verifyApplyButtonWorksCorrectly(){
        jobDescriptionPage.clickApplyButton();
        checkSubmitYourAppFormOpened();
    }

    void verifyJobsList(final String department, final String office){
        verifyPositions(department);
        verifyDepartmens(department);
        verifyLocations(office);
    }

}
