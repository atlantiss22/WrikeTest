package steps;

import enums.SocialNetwork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DefaultSteps {

    private static final String MAIN_PAGE = "https://www.wrike.com";

    private WebDriver driver;

    public DefaultSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void navigateToMainPage() {
        driver.navigate().to(MAIN_PAGE);
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void shouldBeUrl(String url) {
        assert (driver.getCurrentUrl().equals(url));
    }

    public void shouldBeVisible(WebElement element) {
        assert (element.isDisplayed());
    }

    public void shouldHaveSocialButton(List<WebElement> elements, SocialNetwork socialNetwork) {
        boolean exists = false;
        for (WebElement element: elements) {
            if (element.findElement(By.xpath("./a")).getAttribute("href").equals(socialNetwork.getSocialNetwork()))
                exists = true;
        }
        assert (exists);
    }

    public void switchToNewWindow() {
        String currentUrl = driver.getCurrentUrl();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentUrl)) {
                driver.switchTo().window(window);
            }
        }
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
