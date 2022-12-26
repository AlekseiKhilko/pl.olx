package ui.olx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://www.olx.pl/";
    @FindBy(xpath = "//a[@id='topLoginLink']")
    private WebElement loginButton;


    public HomePage openPage() {
        driver.get(BASE_URL);
        acceptAllCookies();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    public CategoryPage openCategoryPage() {
        return new CategoryPage();
    }
}