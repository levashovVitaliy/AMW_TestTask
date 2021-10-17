package constants.test_env;

public enum TestEnvType {

    LOCAL,
    REMOTE;


    public static TestEnvType getEnvType(String envTypeLabel) {
        for(TestEnvType item : TestEnvType.values()) {
            if (envTypeLabel.equals(item.toString()))
                return item;
        }
        throw new RuntimeException("\nUnexpected value: " + envTypeLabel + ".\nPlease check 'testEnvType' field value in '.env' file.");
    }
}
