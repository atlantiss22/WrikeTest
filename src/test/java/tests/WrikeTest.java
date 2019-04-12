package tests;

import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.ResendPage;
import rules.WebDriverRule;
import steps.DefaultSteps;

import static enums.Browser.*;
import static enums.SocialNetwork.*;

public class WrikeTest {

    private static WebDriverRule webDriverRule = new WebDriverRule(CHROME);
    private static DefaultSteps defaultSteps = new DefaultSteps(webDriverRule.getDriver());

    private WebDriverWait wait = new WebDriverWait(webDriverRule.getDriver(), 20);

    private MainPage onMainPage() {
        return new MainPage(webDriverRule.getDriver());
    }

    private ResendPage onResendPage() {
        return new ResendPage(webDriverRule.getDriver());
    }

    @BeforeClass
    public static void startTests() {
        defaultSteps.openMainPage();
    }

    @After
    public void afterTest() {
        defaultSteps.navigateToMainPage();
    }

    @AfterClass
    public static void closeDriver() {
        defaultSteps.closeDriver();
    }

    /**
     * Одна проверка - один тест(кроме кнопки Twitter)
     */

    @Test
    public void shouldSeeResendPage() {
        defaultSteps.openMainPage();
        defaultSteps.clickOn(onMainPage().getTopSubmitButton());
        defaultSteps.enterText(onMainPage().getModalEmailInput(), defaultSteps.randomEmail());
        defaultSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        defaultSteps.shouldBeUrl("https://www.wrike.com/resend/");
    }

    @Test
    public void shouldSeeSuccessForm() {
        defaultSteps.openMainPage();
        defaultSteps.clickOn(onMainPage().getTopSubmitButton());
        defaultSteps.enterText(onMainPage().getModalEmailInput(), defaultSteps.randomEmail());
        defaultSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        defaultSteps.clickRandomQaAnswer(onResendPage().getInterestButtons());
        defaultSteps.clickRandomQaAnswer(onResendPage().getTeamMembersButtons());
        defaultSteps.clickRandomQaAnswer(onResendPage().getPrimaryBusinessButtons());
        defaultSteps.clickOn(onResendPage().getQaSubmitButton());
        wait.until(ExpectedConditions.invisibilityOf(onResendPage().getSurveyForm()));

        defaultSteps.shouldBeVisible(onResendPage().getSurveySuccessForm());
    }

    @Test
    public void shouldSeeResendMessage() {
        defaultSteps.openMainPage();
        defaultSteps.clickOn(onMainPage().getTopSubmitButton());
        defaultSteps.enterText(onMainPage().getModalEmailInput(), defaultSteps.randomEmail());
        defaultSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        defaultSteps.clickOn(onResendPage().getResendEmailButton());
        wait.until(ExpectedConditions.invisibilityOf(onResendPage().getResendEmailButton()));

        defaultSteps.shouldBeVisible(onResendPage().getTextAfterResend());
    }

    @Test
    public void shouldSeeTwitterButtonAndCorrectUrl() {
        defaultSteps.openMainPage();
        defaultSteps.clickOn(onMainPage().getTopSubmitButton());
        defaultSteps.enterText(onMainPage().getModalEmailInput(), defaultSteps.randomEmail());
        defaultSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        defaultSteps.shouldHaveSocialButton(onMainPage().getSocialNetworkButtons(), TWITTER);

        defaultSteps.clickOn(onResendPage().getTwitterButton());
        defaultSteps.switchToNewWindow();

        defaultSteps.shouldBeUrl(TWITTER.getSocialNetwork());
        //без проверки корректной иконки
    }

}
