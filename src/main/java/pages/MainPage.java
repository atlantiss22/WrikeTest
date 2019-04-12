package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'r']//button")
    private WebElement topSubmitButton;

    @FindBy(xpath = "//label[@class='modal-form-trial__label']/input")
    private WebElement modalEmailInput;

    @FindBy(xpath = "//label[@class='modal-form-trial__label']/button")
    private WebElement modalCreateAccountButton;

    // TODO: 12.04.2019 удалить
    @FindBy(xpath = "//a[@href='https://twitter.com/wrike']/parent::li")
    private WebElement twitterButton;

    @FindBy(xpath = "//ul[@class='wg-footer__social-list']/li")
    private List<WebElement> socialNetworkButtons;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTopSubmitButton() {
        return topSubmitButton;
    }

    public WebElement getModalEmailInput() {
        return modalEmailInput;
    }

    public WebElement getModalCreateAccountButton() {
        return modalCreateAccountButton;
    }

    // TODO: 12.04.2019 удалить
    public WebElement getTwitterButton() {
        return twitterButton;
    }

    public List<WebElement> getSocialNetworkButtons() {
        return socialNetworkButtons;
    }
}
