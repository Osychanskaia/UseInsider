package com.useinsider;

public class EpicUseInsider extends TestExecutor {

    private static final String CAREER = "CAREER";
    private static final String OFFICE = "Istanbul, Turkey";
    private static final String DEPARTMENT = "Quality Assurance";
    private static final String JOB_POSITION = "Quality Assurance Tester";

    void checkHomePage(){
        checkHomePage();
        homePage.selectTopMenuItem(CAREER);
    }
}
