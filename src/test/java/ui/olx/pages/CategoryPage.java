package ui.olx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPage extends AbstractPage {
    protected String patternCategoryLocator = "//a[@class='link parent   ']/span[contains(text(), '%s')]/..";
    protected String patternSubCategoryLocator = "//div[@class='subcategories-title'][text()[contains(.,'%s')]]/a";

    public CategoryPage clickCategory(String category) {
        String ShowLocator = String.format(patternCategoryLocator, category);
        WebElement categoryElement = driver.findElement(By.xpath(ShowLocator));
        clickElement(categoryElement);

        return this;
    }

    public ListPage clickSubCategory(String subCategory) {
        String ShowLocator = String.format(patternSubCategoryLocator, subCategory);
        WebElement categoryElement = driver.findElement(By.xpath(ShowLocator));
        waitForElementToBeClickable(categoryElement);
        clickElement(categoryElement);

        return new ListPage();
    }
}