package com.useinsider;

import org.testng.annotations.Test;

public class TestUseInsider extends EpicUseInsider {

    @Test(description = "Insider.com meets the requirements")
    public void testScenario(){
        checkHomePageIsOpened();
        verifyAllBlocksArePresentOnCareerPage();
        checkThatSelectingByOfficeAndDepartmentWorksCorrectly();
        checkCorrectJobPageIsOpenedWhenWeAreSelectingJobPosition();
        verifyApplyButtonWorksCorrectly();
    }
}
