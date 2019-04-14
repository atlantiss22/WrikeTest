package tests;

import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.ResendPage;
import rules.WebDriverRule;
import steps.CreateAccountSteps;
import steps.DefaultSteps;
import steps.SurveySteps;

import static enums.Browser.*;
import static enums.SocialNetwork.*;

public class WrikeTest {

    private static WebDriverRule webDriverRule = new WebDriverRule(CHROME);
    private static DefaultSteps defaultSteps = new DefaultSteps(webDriverRule.getDriver());

    private CreateAccountSteps createAccountSteps = new CreateAccountSteps(webDriverRule.getDriver());
    private SurveySteps surveySteps = new SurveySteps(webDriverRule.getDriver());

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
        createAccountSteps.clickOn(onMainPage().getTopSubmitButton());
        createAccountSteps.enterText(onMainPage().getModalEmailInput(), createAccountSteps.randomEmail());
        createAccountSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        createAccountSteps.shouldBeUrl("https://www.wrike.com/resend/");
    }

    @Test
    public void shouldSeeSuccessForm() {
        createAccountSteps.clickOn(onMainPage().getTopSubmitButton());
        createAccountSteps.enterText(onMainPage().getModalEmailInput(), createAccountSteps.randomEmail());
        createAccountSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        surveySteps.clickRandomQaAnswer(onResendPage().getInterestButtons());
        surveySteps.clickRandomQaAnswer(onResendPage().getTeamMembersButtons());
        surveySteps.clickRandomQaAnswer(onResendPage().getPrimaryBusinessButtons());
        surveySteps.clickOn(onResendPage().getQaSubmitButton());
        wait.until(ExpectedConditions.invisibilityOf(onResendPage().getSurveyForm()));

        surveySteps.shouldBeVisible(onResendPage().getSurveySuccessForm());
    }

    @Test
    public void shouldSeeResendMessage() {
        createAccountSteps.clickOn(onMainPage().getTopSubmitButton());
        createAccountSteps.enterText(onMainPage().getModalEmailInput(), createAccountSteps.randomEmail());
        createAccountSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));
        surveySteps.clickOn(onResendPage().getResendEmailButton());
        wait.until(ExpectedConditions.invisibilityOf(onResendPage().getResendEmailButton()));

        surveySteps.shouldBeVisible(onResendPage().getTextAfterResend());
    }

    @Test
    public void shouldSeeSocialButtonWithCorrectIconAndUrl() {
        createAccountSteps.clickOn(onMainPage().getTopSubmitButton());
        createAccountSteps.enterText(onMainPage().getModalEmailInput(), createAccountSteps.randomEmail());
        createAccountSteps.clickOn(onMainPage().getModalCreateAccountButton());
        wait.until(ExpectedConditions.invisibilityOf(onMainPage().getModalCreateAccountButton()));

        surveySteps.shouldSeeSocialButtonWithCorrectIconAndUrl(onMainPage().getSocialNetworkButtons(), TWITTER);
    }
}
