package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResendPage extends MainPage{

    @FindBy(xpath = "//div[@data-code='interest_in_solution']//button")
    private List<WebElement> interestButtons;

    @FindBy(xpath = "//div[@data-code='team_members']//button")
    private List<WebElement> teamMembersButtons;

    @FindBy(xpath = "//div[@data-code='primary_business']//button")
    private List<WebElement> primaryBusinessButtons;

    @FindBy(xpath = "//button[text() = 'Submit results']")
    private WebElement qaSubmitButton;

    @FindBy(xpath = "//div[@class='wg-grid']//button[text() = 'Resend email']")
    private WebElement resendEmailButton;

    @FindBy(xpath = "//div[@class='survey-success']")
    private WebElement surveySuccessForm;

    @FindBy(xpath = "//form[@class='survey-form']")
    private WebElement surveyForm;

    @FindBy(xpath = "//p[@class='h4 subtitle']//span")
    private WebElement textAfterResend;

    public ResendPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getInterestButtons() {
        return interestButtons;
    }

    public List<WebElement> getTeamMembersButtons() {
        return teamMembersButtons;
    }

    public List<WebElement> getPrimaryBusinessButtons() {
        return primaryBusinessButtons;
    }

    public WebElement getQaSubmitButton() {
        return qaSubmitButton;
    }

    public WebElement getResendEmailButton() {
        return resendEmailButton;
    }

    public WebElement getSurveySuccessForm() {
        return surveySuccessForm;
    }

    public WebElement getSurveyForm() {
        return surveyForm;
    }

    public WebElement getTextAfterResend() {
        return textAfterResend;
    }
}
