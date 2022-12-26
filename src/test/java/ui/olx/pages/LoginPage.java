package ui.olx.pages;

import org.openqa.selenium.By;
import ui.olx.entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@data-testid='login-submit-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@role='tab' and  @data-testid='select-register-tab']")
    private WebElement registrButton;
    @FindBy(xpath = "//div[@data-testid='form-error-wrapper']/p")
    protected WebElement errorAlert;
    @FindBy(xpath = "//p[@data-testid='textField-error-message']")
    protected WebElement errorUserNameMessage;
    @FindBy(xpath = "//p[@data-testid='password-error-message']")
    protected WebElement errorPasswordMessage;

    public LoginPage authorize(User user) {
        claerUserNameAndPassword();
        inputUserName.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public void claerUserNameAndPassword() {
        inputUserName.clear();
        inputPassword.clear();
    }

    public LoginPage typeLoginForm(User user) {
        inputUserName.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());

        return this;
    }

    public RegisterPage clickRegisterButton(){
        registrButton.click();
        return new RegisterPage();
    }

    public String getUserNameErrorMessage() {
        String message = waitForVisibilityOfElement(errorUserNameMessage).getText();
        return message;
    }

    public String getPasswordErrorMessage() {
        String message = waitForVisibilityOfElement(errorPasswordMessage).getText();
        return message;
    }

    public String getErrorAlert() {
        String message = waitForVisibilityOfElement(errorAlert).getText();
        return message;
    }

}