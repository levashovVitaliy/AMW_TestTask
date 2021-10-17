package suites;

import constants.project_env.Project;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.home_page.HomePage;
import pages.base.BasePage;
import utils.web_driver.WebDriverHandler;


public class UiTest extends UiTestSuite {

    protected WebDriver driver;
    protected BasePage basePage;
    protected String testType;
    protected HomePage homePage;


    @BeforeClass(groups = {"smoke", "regression"})
    public void initObjects() {
        initPages();
    }


    @BeforeMethod(groups = {"smoke", "regression"})
    public void prepareTest() {
        basePage.openHomePage();
    }


    @Parameters({"testType"})
    @BeforeTest(groups = {"smoke", "regression"})
    public void setBasePage(String testType) {
        driver = WebDriverHandler.getDriver();
        basePage = new BasePage(driver, projectLabel, projectEnvLabel);
        this.testType = testType;
    }


    protected void initPages() {
        initHomePage();
    }


    protected void initHomePage() {
        if (projectLabel.equals(Project.US.toString()))
            homePage = basePage.getInstance(HomePage.class);
        else throw new RuntimeException("\nUnexpected value: " + projectLabel + ".\nPlease check projectLabel or 'project' field value in '.env' file.");
    }
}
