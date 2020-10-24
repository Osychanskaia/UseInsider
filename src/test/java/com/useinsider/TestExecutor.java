package com.useinsider;

import com.useinsider.core.AbstractTest;
import com.useinsider.pages.CareerPage;
import com.useinsider.pages.HomePage;
import com.useinsider.pages.JobDescriptionPage;
import com.useinsider.pages.SubmitYourApplicationPage;
import org.testng.Assert;

import java.util.List;

public class TestExecutor extends AbstractTest {

        HomePage homePage = new HomePage();
        CareerPage careerPage = new CareerPage();
        JobDescriptionPage jobDescriptionPage = new JobDescriptionPage();
        SubmitYourApplicationPage submitYourApplicationPage = new SubmitYourApplicationPage();

        void checkHomePage(){
            homePage.openHomePage();
            Assert.assertTrue(homePage.checkLogoIsPresent());
        }

        void checkBlocksArePresentOnCareerPage(){
            Assert.assertTrue(careerPage.verifyBlocksArePresent());
        }

        void selectByOfficesAndDepartments(final String office, final String department) {
            careerPage.selectByOffices(office);
            careerPage.selectByDepartments(department);
            Assert.assertTrue(careerPage.getJobsCount() > 0);
        }

        void verifyJobsList(final String department, final String office){
            verifyPositions(department);
            verifyDepartmens(department);
            verifyLocations(office);
        }

        void verifyPositions(final String department){
            List <String> positionList = careerPage.getPositionList();
            for (String position : positionList){
                Assert.assertTrue(position.contains(department));
            }
        }

        void verifyDepartmens(final String department){
            List <String> departmentList = careerPage.getDepartmentList();
            for (String dep : departmentList){
                Assert.assertEquals(dep, department);
            }
        }

        void verifyLocations(final String office){
            List <String> locationList = careerPage.getLocationsList();
            for (String location : locationList){
                Assert.assertEquals(location, office);
            }
        }

        void checkCorrectJobPageIsOpened(final String job){
            Assert.assertEquals(job,jobDescriptionPage.getJobTitle());
            Assert.assertTrue(jobDescriptionPage.isApplyButtonPresent());
            Assert.assertTrue(jobDescriptionPage.isDescriptionSectionPresent());
            Assert.assertTrue(jobDescriptionPage.isRequirementsSectionPresent());
        }

        void checkSubmitYourAppFormOpened(){
            Assert.assertTrue(submitYourApplicationPage.isSubmitAppButtonPresent());
            Assert.assertTrue(submitYourApplicationPage.isSubmitYourAppFormPresent());
        }

}
