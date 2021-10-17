package suites;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.web_driver.WebDriverHandler;

import java.util.Objects;

public class UiTestSuite {

    protected String projectLabel;
    protected String projectEnvLabel;
    protected String browser;


    @BeforeSuite(groups = {"smoke", "regression"})
    public void setTestSuiteLabels() {
        projectLabel = Dotenv.load().get("project");
        projectEnvLabel = Dotenv.load().get("projectEnv");
        browser = Objects.requireNonNull(Dotenv.load().get("browser")).toLowerCase();
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        WebDriverHandler.getDriver().quit();
    }
}
