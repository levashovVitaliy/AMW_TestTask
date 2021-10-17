package utils.web_driver;

import constants.test_env.TestEnvType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FirefoxDriverInitializer implements DriverInitializer {

    private static volatile FirefoxDriverInitializer INSTANCE;
    private FirefoxOptions options = new FirefoxOptions();
    private WebDriver driver;


    private FirefoxDriverInitializer() {
        setUserAgent();
        setProxy();
        init();
    }


    public static FirefoxDriverInitializer getInstance() {
        if (INSTANCE == null) {
            synchronized (FirefoxDriverInitializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FirefoxDriverInitializer();
                }
            }
        }
        return INSTANCE;
    }


    private void setUserAgent() {
        if (config.getUserAgent() != null) {
            options.addPreference("general.useragent.override", config.getUserAgent());
        }
    }


    private void setProxy() {
        if (config.getProxy() != null) {
            options.setCapability("proxy", config.getProxy());
        }
    }


    private void init() {
        WebDriverManager.chromedriver().setup();

        if (config.getTestEnvType() == TestEnvType.LOCAL)
            driver = setLocalWebDriver();
        else if (config.getTestEnvType() == TestEnvType.REMOTE)
            driver = setRemoteWebDriver();
        else throw new RuntimeException("\nUnexpected value: " + config.getTestEnvType() + ".\nPlease check initiating private method in ChromeDriverInitializer class.");

        driver.manage().window().setSize(new Dimension(config.getRemoteServerWindowWidth(), config.getRemoteServerWindowHeight()));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait());
        driver.manage().timeouts().pageLoadTimeout(config.getPageLoadTimeout());
        driver.manage().timeouts().setScriptTimeout(config.getScriptTimeout());
    }


    private WebDriver setRemoteWebDriver() {
        return new RemoteWebDriver(config.getRemoteServer(), options);
    }


    private WebDriver setLocalWebDriver() {
        return new FirefoxDriver(options);
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
