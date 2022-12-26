package ui.olx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='w0']/div/article")
    protected List<WebElement> tvShowCardList;
    @FindBy(xpath = "//*[@class='callout primary']/p")
    protected WebElement searchResultMessageField;

}