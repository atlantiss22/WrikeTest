package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import rules.WebDriverRule;
import steps.DefaultSteps;

import static enums.Browser.*;

public class WrikeTest {

    private static DefaultSteps defaultSteps;
    public WebDriverRule webDriverRule = new WebDriverRule(CHROME);

    private MainPage onMainPage() {
        return new MainPage(webDriverRule.getDriver());
    }

    @Before
    public void initSteps() {
        defaultSteps = new DefaultSteps(webDriverRule.getDriver());
    }

    @AfterClass
    public static void closeDriver() {
        defaultSteps.closeDriver();
    }

    @Test
    public void firstTest() {
        defaultSteps.openMainPage();
        defaultSteps.clickOn(onMainPage().getTopSubmitButton());
        //тут будет генерация
        defaultSteps.enterText(onMainPage().getModalEmailInput(), "abcdef+wpt@wriketask.qaa");
        defaultSteps.clickOn(onMainPage().getModalCreateAccountButton());
        //дождаться появления новой страницы, убрать sleep
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //написать matcher(assertThat) вместо should
        defaultSteps.shouldBeUrl("https://www.wrike.com/resend/");
    }

}
