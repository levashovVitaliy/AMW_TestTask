package utils.web_driver;

import constants.test_env.DeviceType;
import constants.test_env.EmulatedDevice;
import constants.test_env.TestEnvType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class WebDriverConfig {

    private final Dotenv env = Dotenv.load();
    private final TestEnvType testEnvType;
    private final DeviceType deviceType;
    private final Duration implicitlyWait;
    private final Duration pageLoadTimeout;
    private final Duration scriptTimeout;
    private final String userAgent;
    private final URL remoteServer;
    private final Integer remoteServerWindowWidth;
    private final Integer remoteServerWindowHeight;
    private final Proxy proxy;
    private final EmulatedDevice device;


    public WebDriverConfig() {
        this.testEnvType = testEnvType();
        this.deviceType = deviceType();
        this.pageLoadTimeout = pageLoadTimeout();
        this.implicitlyWait = implicitlyWait();
        this.scriptTimeout = scriptTimeout();
        this.userAgent = userAgent();
        this.remoteServer = remoteServer();
        this.remoteServerWindowWidth = remoteServerWindowWidth();
        this.remoteServerWindowHeight = remoteServerWindowHeight();
        this.proxy = proxy();
        this.device = device();
    }


    private TestEnvType testEnvType() {
        String testEnvTypeLabel = env.get("testEnvType");
        return TestEnvType.getEnvType(testEnvTypeLabel);
    }


    private DeviceType deviceType() {
        String deviceTypeLabel = env.get("deviceType");
        return DeviceType.getDeviceType(deviceTypeLabel);
    }


    private Duration implicitlyWait() {
        String implicitlyWait = env.get("implicitlyWait");
        if(implicitlyWait != null)
            return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        else return null;
    }


    private Duration pageLoadTimeout() {
        String pageLoadTimeout = env.get("pageLoadTimeout");
        if(pageLoadTimeout != null)
            return Duration.ofSeconds(Long.parseLong(pageLoadTimeout));
        else return null;
    }


    private Duration scriptTimeout() {
        String scriptTimeout = env.get("scriptTimeout");
        if(scriptTimeout != null)
            return Duration.ofSeconds(Long.parseLong(scriptTimeout));
        else return null;
    }


    private String userAgent() {
        String userAgent = env.get("userAgent");
        if (!userAgent.equals(""))
            return userAgent;
        return null;
    }


    private URL remoteServer() {
        String hostname = env.get("remoteHostName");
        String port = env.get("remoteHostPort");

        if(!hostname.equals("") && port != null) {
            try {
                return new URL(hostname + ":" + port + "/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return null;
    }


    private Integer remoteServerWindowWidth() {
        String width = env.get("remoteWindowWidth");

        if(!width.equals(""))
            return Integer.parseInt(width);
        return null;
    }


    private Integer remoteServerWindowHeight() {
        String height = env.get("remoteWindowHeight");

        if(!height.equals(""))
            return Integer.valueOf(height);
        return null;
    }


    private Proxy proxy() {
        String hostname = env.get("proxyHost");
        String port = env.get("proxyPort");
        String username = env.get("proxyUsername");
        String password = env.get("proxyPassword");

        if(!hostname.equals("") && !port.equals("") && !username.equals("") && !password.equals("")) {
            String proxySetting = "http://" + username + ":" + password + "@" + hostname + ":" + port;
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(proxySetting);
            return proxy;
        } else return null;
    }


    private EmulatedDevice device() {
        String deviceLabel = env.get("device");
        return EmulatedDevice.getDevice(deviceLabel);
    }


    public TestEnvType getTestEnvType() {
        return testEnvType;
    }


    public DeviceType getDeviceType() {
        return deviceType;
    }


    public Duration getPageLoadTimeout() {
        return pageLoadTimeout;
    }


    public Duration getImplicitlyWait() {
        return implicitlyWait;
    }


    public Duration getScriptTimeout() {
        return scriptTimeout;
    }


    public String getUserAgent() {
        return userAgent;
    }


    public URL getRemoteServer() {
        return remoteServer;
    }


    public Integer getRemoteServerWindowWidth() {
        return remoteServerWindowWidth;
    }


    public Integer getRemoteServerWindowHeight() {
        return remoteServerWindowHeight;
    }


    public Proxy getProxy() {
        return proxy;
    }


    public EmulatedDevice getDevice() {
        return device;
    }
}
