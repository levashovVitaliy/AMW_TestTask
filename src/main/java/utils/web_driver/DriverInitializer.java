package utils.web_driver;

import org.openqa.selenium.WebDriver;

public interface DriverInitializer {

    WebDriverConfig config = new WebDriverConfig();

    WebDriver getWebDriver();
}
