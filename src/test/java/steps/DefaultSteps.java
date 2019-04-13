package steps;

import enums.SocialNetwork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

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

    public void clickRandomQaAnswer(List<WebElement> elements) {
        Random random = new Random();
        int number = random.nextInt(elements.size());
        if (elements.get(number).getText().contains("Other")) {
            elements.get(number).click();
            elements.get(number).findElement(By.tagName("input")).sendKeys("test");
        } else {
            elements.get(number).click();
        }
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

    public String randomEmail() {
        Random random = new Random();
        //максимальная длина изменяемой части email = 238
        int length = random.nextInt(238);
        char nextChar;
        StringBuilder email = new StringBuilder();

        for (int i = 0; i < length; i++) {
            nextChar = (char) (random.nextInt(25) + 97);
            email.append(nextChar);
        }
        email.append("+wpt@wriketask.qaa");
        return email.toString();
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
