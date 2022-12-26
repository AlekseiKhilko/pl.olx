package ui.olx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.olx.entity.User;

public class RegisterPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//form[@data-testid='register-form']")
    private WebElement formRegister;
    @FindBy(xpath = "//button[@data-testid='register-button']")
    private WebElement registerButton;

    public AuthorizedHomePage register(User user) {
        waitForVisibilityOfElement(formRegister);
        inputUserName.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        registerButton.click();
        return new AuthorizedHomePage();
    }
}
