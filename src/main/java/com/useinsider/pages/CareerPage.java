package com.useinsider.pages;

import com.useinsider.core.AbstractPage;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.useinsider.utils.WebDriverUtil.waitForAsyncExecution;
import static org.openqa.selenium.By.xpath;

public class CareerPage extends AbstractPage {
    private static final String CULTURE_BLOCK = "//div[@id='culture']//section[@class='grid-container']";
    private static final String LOCATIONS_BLOCK = "//div[@id='locations']/following-sibling::div[contains(@class,'teamSect')]";
    private static final String TEAMS_BLOCK = "//div[@id='teams']/following-sibling::div[contains(@class, 'ourTeams')][1]";
    private static final String JOBS_BLOCK = "//div[@id='jobs']/following-sibling::div//div[@id='jobs-container']";
    private static final String LIFE_AT_INSIDER_BLOCK = "//div[@id='life-at-insider']/following-sibling::div[@id='instagram']";
    private static final String CAREER_OPPORTUNITIES = "//h2[text()='CAREER OPPORTUNITIES']";
    private static final String OFFICE_DROPDOWN = "//select[@class='jobs-locations']";
    private static final String DEPARTMENT_DROPDOWN = "//select[@class='jobs-teams']";
    private static final String JOBS_LIST = "//div[@class='jobs-list']//a";
    private static final String JOB_POSITIONS = "//div[@class='jobs-list']//a/span[1]";
    private static final String JOB_DEPARTMENTS = "//div[@class='jobs-list']//a/span[2]";
    private static final String JOB_LOCATIONS = "//div[@class='jobs-list']//a/span[3]";

    public boolean verifyBlocksArePresent(){
        return checkCultureBlockIsPresent() &&
                checkLocationsBlockIsPresent() &&
                checkTeamsBlockIsPresent() &&
                checkJobsBlockIsPresent() &&
                checkLifeAtInsiderBlockIsPresent();
    }

    private boolean checkCultureBlockIsPresent(){
        return isElementPresent(CULTURE_BLOCK);
    }

    private boolean checkLocationsBlockIsPresent(){
        return isElementPresent(LOCATIONS_BLOCK);
    }

    private boolean checkTeamsBlockIsPresent(){
        return isElementPresent(TEAMS_BLOCK);
    }

    private boolean checkJobsBlockIsPresent(){
        return isElementPresent(JOBS_BLOCK);
    }

    private boolean checkLifeAtInsiderBlockIsPresent(){
        return isElementPresent(LIFE_AT_INSIDER_BLOCK);
    }

    public void scrollToCareerOpportunities(){
        scrollToElementRealization(findBy(CAREER_OPPORTUNITIES));
    }

    public void selectByOffices(String office){
        Select drpOffice = new Select(findBy(OFFICE_DROPDOWN));
        drpOffice.selectByVisibleText(office);
        waitForAsyncExecution();
    }

    public void selectByDepartments(String department) {
        Select drpDepartment = new Select(findBy(DEPARTMENT_DROPDOWN));
        drpDepartment.selectByVisibleText(department);
        waitForAsyncExecution();
    }

    public int getJobsCount(){
        return getDriver().findElements(xpath(JOBS_LIST)).size();
    }

    public List<String> getPositionList(){
        return getDriver().findElements(xpath(JOB_POSITIONS)).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDepartmentList(){
        return getDriver().findElements(xpath(JOB_DEPARTMENTS)).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getLocationsList(){
        return getDriver().findElements(xpath(JOB_LOCATIONS)).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectJobPosition(String jobPosition) {
        Optional<WebElement> jobTitle = getDriver().findElements(xpath(JOB_POSITIONS)).stream().filter(e -> e.getText().equals(jobPosition)).findFirst();
        jobTitle.ifPresent(WebElement::click);
    }

}
