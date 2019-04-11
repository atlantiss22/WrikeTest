package enums;

public enum Browser {

    FIREFOX("webdriver.gecko.driver"),
    CHROME("webdriver.chrome.driver");

    private final String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
