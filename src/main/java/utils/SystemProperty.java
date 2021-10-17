package utils;

public class SystemProperty {

    private SystemProperty() {}


    public static String fileSeparator() {
        return System.getProperty("file.separator");
    }

    public static String homeDirectory() {
        return System.getProperty("home.dir");
    }

    public static String javaClasspath() {
        return System.getProperty("java.class.path");
    }

    public static String javaHome() {
        return System.getProperty("java.home");
    }

    public static String javaVendor() {
        return System.getProperty("java.vendor");
    }

    public static String javaVendorUrl() {
        return System.getProperty("java.vendor.url");
    }

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String lineSeparator() {
        return System.getProperty("line.separator");
    }

    public static String osArch() {
        return System.getProperty("os.arch");
    }

    public static String osName() {
        return System.getProperty("os.name");
    }

    public static String osVersion() {
        return System.getProperty("os.version");
    }

    public static String pathSeparator() {
        return System.getProperty("path.separator");
    }

    public static String projectDirectory() {
        return System.getProperty("user.dir");
    }

    public static String userHome() {
        return System.getProperty("user.home");
    }

    public static String userId() {
        return System.getProperty("user.id");
    }

    public static String userName() {
        return System.getProperty("user.name");
    }
}
