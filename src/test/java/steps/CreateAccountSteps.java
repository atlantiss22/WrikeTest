package steps;

import org.openqa.selenium.WebDriver;
import java.util.Random;

public class CreateAccountSteps extends DefaultSteps {

    public CreateAccountSteps(WebDriver driver) {
        super(driver);
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
}
