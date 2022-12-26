package ui.olx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVShowCalendarPage extends AbstractPage {
    @FindBy(xpath = "//*[@name='filter']")
    private WebElement selectFilter;
    @FindBy(xpath = "//*[@value='popular']")
    private WebElement filterPopular;
    @FindBy(id = "month")
    private WebElement presentMonthName;
    @FindBy(xpath = "//div[contains(@class,'text-left')]/a")
    private WebElement previousMonth;
    @FindBy(xpath = "//div[contains(@class,'text-right')]/a")
    private WebElement nextMonth;
    protected String patternShowLocator = "//div[contains(@class,'%s-%s')]//li";

    public TVShowCalendarPage selectShowCalendarFilter() {
        selectFilter.click();
        waitForVisibilityOfElement(filterPopular).click();
        return this;
    }

}