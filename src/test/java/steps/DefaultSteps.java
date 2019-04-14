package steps;

import enums.SocialNetwork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.List;

import static org.junit.Assert.*;

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
        assertEquals("Должен быть URL", driver.getCurrentUrl(), url);
    }

    public void shouldBeVisible(WebElement element) {
        assertTrue("Должны видеть элемент", element.isDisplayed());
    }

    public void shouldSeeSocialButtonWithCorrectIconAndUrl(List<WebElement> elements, SocialNetwork socialNetwork) {
        boolean exists = false;
        for (WebElement element : elements) {
            //у кнопки корректный URL для перехода и xlink:href для отрисовки в блоке shadow-root
            if (element.findElement(By.xpath("./a")).getAttribute("href").equals(socialNetwork.getSocialNetwork())
                    && element.findElement(By.xpath(".//*[name() = 'use']")).getAttribute("xlink:href").equals(getXlink(socialNetwork))){
                element.click();
                switchToNewWindow();
                //после перехода корректный URL в адресной строке
                if (driver.getCurrentUrl().equals(socialNetwork.getSocialNetwork())) {
                    exists = true;
                    break;
                } else {
                    break;
                }
            }
        }
        assertTrue("Должна присутствовать на странице", exists);
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

    private static String getXlink(SocialNetwork socialNetwork) {
        String xlink = "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#"
                + socialNetwork.toString().toLowerCase();
        return xlink;
    }
}
