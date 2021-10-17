import io.github.cdimascio.dotenv.Dotenv;
import org.testng.TestNG;
import utils.web_driver.WebDriverHandler;

import java.util.LinkedList;
import java.util.List;


public class TestRunner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(suites());
        testNG.run();
        WebDriverHandler.getDriver().quit();
    }

    private static List<String> suites() {
        List<String> suites = new LinkedList<>();
        String testType = Dotenv.load().get("testType");

        if (testType.equals("smoke")) {
            suites.add("src/test/java/suites/smoke-all.xml");
            return suites;
        }

        throw new RuntimeException("\nUnexpected value: " + testType + ".\nPlease check 'testType' field value in '.env' file.");
    }
}
