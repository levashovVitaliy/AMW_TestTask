package utils.web_driver;

import constants.test_env.DeviceType;
import constants.test_env.TestEnvType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;


public class ChromeDriverInitializer implements DriverInitializer {

    private static volatile ChromeDriverInitializer INSTANCE;
    private ChromeOptions options = new ChromeOptions();
    private WebDriver driver;


    private ChromeDriverInitializer() {
        setUserAgent();
        setProxy();
        if (config.getDeviceType() == DeviceType.MOBILE)
            setEmulatedDevice();
        init();
    }


    public static ChromeDriverInitializer getInstance() {
        if (INSTANCE == null) {
            synchronized (ChromeDriverInitializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ChromeDriverInitializer();
                }
            }
        }
        return INSTANCE;
    }


    private void setUserAgent() {
        if (config.getUserAgent() != null) {
            options.addArguments("--user-agent=" + config.getUserAgent());
        }
    }


    private void setProxy() {
        if (config.getProxy() != null) {
            options.setProxy(config.getProxy());
        }
    }


    private void setEmulatedDevice() {
        if (config.getDevice() != null) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", config.getDevice().deviceName);
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        } else throw new RuntimeException("\nDeviceType set as MOBILE, but emulated device is not chosen.\nPlease check 'device' field value in '.env' file.");
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
        options.addArguments("--window-size=" + config.getRemoteServerWindowWidth() + "," + config.getRemoteServerWindowHeight());
        return new RemoteWebDriver(config.getRemoteServer(), options);
    }


    private WebDriver setLocalWebDriver() {
        return new ChromeDriver(options);
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
