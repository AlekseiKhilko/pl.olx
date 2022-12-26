package ui.olx.steps;


import ui.olx.entity.User;
import ui.olx.pages.HomePage;
import ui.olx.utils.UserCreator;

public class RegisterStep {
    public void registerTest() {
        User user = new UserCreator().createDefaultUser();
        new HomePage()
                .openPage()
                .clickLoginButton()
                .clickRegisterButton()
                .register(user);
    }
}
