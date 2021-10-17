package utils.web_driver;

import constants.test_env.TestEnvType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class EdgeDriverInitializer implements DriverInitializer {

    private static volatile EdgeDriverInitializer INSTANCE;
    private EdgeOptions options = new EdgeOptions();
    private WebDriver driver;


    private EdgeDriverInitializer() {
        init();
    }


    public static EdgeDriverInitializer getInstance() {
        if (INSTANCE == null) {
            synchronized (EdgeDriverInitializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EdgeDriverInitializer();
                }
            }
        }
        return INSTANCE;
    }


    private void init() {
        WebDriverManager.chromedriver().setup();

        if (config.getTestEnvType() == TestEnvType.LOCAL)
            driver = setLocalWebDriver();
        else if (config.getTestEnvType() == TestEnvType.REMOTE)
            driver = setRemoteWebDriver();
        else throw new RuntimeException("\nUnexpected value: " + config.getTestEnvType() + ".\nPlease check initiating private method in ChromeDriverInitializer class.");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait());
        driver.manage().timeouts().pageLoadTimeout(config.getPageLoadTimeout());
        driver.manage().timeouts().setScriptTimeout(config.getScriptTimeout());
    }


    private WebDriver setRemoteWebDriver() {
        WebDriver driver = new RemoteWebDriver(config.getRemoteServer(), options);
        driver.manage().window().setSize(new Dimension(config.getRemoteServerWindowWidth(), config.getRemoteServerWindowHeight()));
        return driver;
    }


    private WebDriver setLocalWebDriver() {
        return new EdgeDriver(options);
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
