package utils.web_driver;

import constants.test_env.Browser;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import java.util.Objects;


public class WebDriverHandler {

    private WebDriverHandler() {
    }

    public static WebDriver getDriver() {
        String browserLabel = Dotenv.load().get("browser");

        if (Objects.equals(browserLabel, Browser.CHROME.toString()))
            return ChromeDriverInitializer.getInstance().getWebDriver();
        if (Objects.equals(browserLabel, Browser.FIREFOX.toString()))
            return FirefoxDriverInitializer.getInstance().getWebDriver();
        if (Objects.equals(browserLabel, Browser.EDGE.toString()))
            return EdgeDriverInitializer.getInstance().getWebDriver();

        throw new RuntimeException("\nUnexpected value:" + browserLabel + ".\nPlease check 'browser' field value in '.env' file.");
    }
}
