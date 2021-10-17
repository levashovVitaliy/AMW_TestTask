package constants.project_env;

public enum BaseUrl {
    PROD        ("https://nebuladao.xyz/");

    public final String url;

    BaseUrl(String url) {
        this.url = url;
    }


    public static String getBaseUrl(String label) {
        for(BaseUrl item : BaseUrl.values()) {
            if (item.toString().equals(label))
                return item.url;
        }
        throw new RuntimeException("\nUnexpected value: " + label + ".\nPlease check env value or 'projectEnv' field value in '.env' file.");
    }
}
