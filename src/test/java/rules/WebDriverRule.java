package rules;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverRule {

    private WebDriver driver;

    public WebDriverRule(Browser browser) {
        switch (browser){
            case CHROME:
                System.setProperty(browser.getBrowser(), "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(browser.getBrowser(), "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
