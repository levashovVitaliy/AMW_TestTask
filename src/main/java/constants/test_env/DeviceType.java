package constants.test_env;

public enum DeviceType {

    DESKTOP,
    MOBILE;


    public static DeviceType getDeviceType(String deviceTypeLabel) {
        for(DeviceType item : DeviceType.values()) {
            if (deviceTypeLabel.equals(item.toString()))
                return item;
        }
        return null;
    }
}
