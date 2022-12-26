package ui.olx.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.olx.driver.DriverSingleton;
import ui.olx.entity.User;
import ui.olx.pages.AuthorizedHomePage;
import ui.olx.pages.LoginPage;
import ui.olx.steps.AuthorizeStep;
import ui.olx.utils.UserCreator;

public class LoginTest extends AbstractTest {
    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void loginEmptyUserNameAndPasswordTest(){
        User user = UserCreator.createUser("", "");
        LoginPage loginPage = new AuthorizeStep().logIn(user);
        Assert.assertTrue(loginPage.getUserNameErrorMessage().contains("Wpisz swój e-mail"));
        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Wpisz hasło"));
    }

    @Test
    public void loginEmptyPasswordTest(){
        User user = UserCreator.createUser(UserCreator.USER_NAME, "");
        LoginPage loginPage = new AuthorizeStep().logIn(user);
        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Wpisz hasło"));
    }

    @Test
    public void loginEmptyUserNameTest(){
        User user = UserCreator.createUser("", UserCreator.USER_PASSWORD);
        LoginPage loginPage = new AuthorizeStep().logIn(user);
        Assert.assertTrue(loginPage.getUserNameErrorMessage().contains("Wpisz swój e-mail"));
    }

    @Test
    public void loginShortPasswordTest(){
        User user = UserCreator.createUser(UserCreator.USER_NAME, "1");
        LoginPage loginPage = new AuthorizeStep().logIn(user);
        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Masz pewność co do hasła? Jest zbyt krótkie."));
    }

    @Test
    public void loginNotExistsUserNameAndPasswordTest(){
        User user = UserCreator.createUser("noexist@gmail.com", "Noexists123456");
        LoginPage loginPage = new AuthorizeStep().logIn(user);
        Assert.assertTrue(loginPage.getErrorAlert().contains("Nieprawidłowy login lub hasło"));
    }

    @Test
    public void loginCorrectUserNameAndPasswordTest(){
        User user = UserCreator.createDefaultUser();
        new AuthorizeStep().logIn(user);
        AuthorizedHomePage authorizedHomePage = new AuthorizedHomePage();
        Assert.assertTrue(authorizedHomePage.getUserName().contains("6001mx7"));
    }
}
