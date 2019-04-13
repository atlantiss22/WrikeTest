package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SurveySteps extends DefaultSteps {

    public SurveySteps(WebDriver driver) {
        super(driver);
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
}
