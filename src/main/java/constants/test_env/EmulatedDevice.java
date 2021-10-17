package constants.test_env;

public enum EmulatedDevice {

    IPHONE_8        ("iPhone 8"),
    IPHONE_8_PLUS   ("iPhone 8 Plus"),
    IPAD            ("iPad"),
    IPAD_PRO        ("iPad Pro"),
    NEXUS_5         ("Nexus 5"),
    NEXUS_7         ("Nexus 7"),
    GALAXY_NOTE_II  ("Galaxy Note II"),
    PIXEL_2         ("Pixel 2");

    public final String deviceName;


    EmulatedDevice(String deviceName) {
        this.deviceName = deviceName;
    }


    public static EmulatedDevice getDevice(String deviceLabel) {
        if (deviceLabel.equals(""))
            return null;
        for(EmulatedDevice item : EmulatedDevice.values()) {
            if (deviceLabel.equals(item.toString()))
                return item;
        }
        throw new RuntimeException("\nUnexpected value: " + deviceLabel + ".\nPlease check 'device' field value in '.env' file.");
    }
}
