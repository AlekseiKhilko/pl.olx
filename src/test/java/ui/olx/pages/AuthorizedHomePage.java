package ui.olx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
public class AuthorizedHomePage extends AbstractPage {
    private String MyOlxLinkLocator = "//div[@data-testid='qa-user-dropdown']/div/a";
    private String userNameLocator = "//div[@data-testid='dropdown-user-id']/..";
    private String waiteElementLocator = "//h3[@data-testid='header-title']";

    public AuthorizedHomePage waitLoad() {
        waitForPresenceOfElementLocated(waiteElementLocator);
        return this;
    }
    public void moveOverMyOlxLink() {
        WebElement elementMyOlxLink = waitForPresenceOfElementLocated(MyOlxLinkLocator);
        Actions action = new Actions(driver);
        action.moveToElement(elementMyOlxLink).build().perform();
    }

    public String getUserName() {
        waitLoad();
        moveOverMyOlxLink();
        WebElement elementUserName = waitForPresenceOfElementLocated(userNameLocator);
        return elementUserName.getText();
    }
}