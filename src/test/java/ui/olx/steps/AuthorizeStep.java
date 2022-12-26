package ui.olx.steps;

import org.openqa.selenium.interactions.Actions;
import ui.olx.entity.User;
import ui.olx.pages.AuthorizedHomePage;
import ui.olx.pages.HomePage;
import ui.olx.pages.LoginPage;

public class AuthorizeStep extends LoginPage {
    public LoginPage logIn(User user) {
        return new HomePage().openPage()
                .clickLoginButton()
                .authorize(user);
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