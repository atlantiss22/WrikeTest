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

    public List<WebElement> getSocialNetworkButtons() {
        return socialNetworkButtons;
    }
}
