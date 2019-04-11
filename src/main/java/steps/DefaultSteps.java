package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultSteps {

    public static final String MAIN_PAGE = "https://www.wrike.com";

    private WebDriver driver;

    public DefaultSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void shouldBeUrl(String url) {
        assert(driver.getCurrentUrl().equals(url));
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
