package ui.olx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListPage extends AbstractPage {
    // //button[class='laq-layout__actions--decline']
    protected String patternFilterLabelLocator = "//div[@data-testid='listing-filters']//p[contains(@class, '-TextStyled')][contains(text(), '%s')]";
    protected String patternFilterDropdownLocator = "//div[@data-testid='listing-filters']//p[contains(@class, '-TextStyled')][contains(text(), '%s')]/following::div";
    protected String patternFilterDropdownListLocator = "//label[@data-testid='label']/p";
    private String waiteElementLocator = "//form[@data-testid='listing-filters-form']";

    private String searchInputLocator = "//input[@data-testid='search-input']";
    private String priceFromInputLocator = "//input[@data-testid='range-from-input']";
    private String priceToInputLocator = "//input[@data-testid='range-to-input']";
    private String buttonSearchLocator = "//button[@name='searchBtn']";
    private String productListLocator = "//h6[contains(@class, 'TextStyled')]";
    private String totalCountLocator = "//div[@data-testid='total-count']/span";


    /*
    Stan = Nowe
Płeć = Damskie

     */

    public ListPage waitLoad() {
        waitForPresenceOfElementLocated(waiteElementLocator);
        return this;
    }

    public ListPage fillFilterForm(String search, String priceFrom, String priceTo, Map<String, String> selectFieldMap) {
        waitForPresenceOfElementLocated(searchInputLocator).clear();
        waitForPresenceOfElementLocated(searchInputLocator).sendKeys(search);
        waitForPresenceOfElementLocated(priceFromInputLocator).sendKeys(priceFrom);
        waitForPresenceOfElementLocated(priceToInputLocator).sendKeys(priceTo);

        for (Map.Entry<String, String> entry : selectFieldMap.entrySet()) {
            selectFilterDropdown(entry.getKey(), entry.getValue());
        }
        clickElement(waitForPresenceOfElementLocated(buttonSearchLocator));
        waitForPageLoad();
        return this;
    }

    public List<String> geProductList() {
        //waitForPageLoad();
        List<WebElement> productList = waitForPresenceOfAllElementsLocatedBy(productListLocator);
        return productList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public Integer getTotalCout() {
        WebElement elementTotalCount = waitForPresenceOfElementLocated(totalCountLocator);
        return Integer.parseInt(elementTotalCount.getText().replaceAll("[^0-9]+", ""));
    }

    public Boolean selectFilterDropdown(String filterName, String filterValue) {
        String filterDropdownLocator = String.format(patternFilterDropdownLocator, filterName);
        WebElement filterDropdownElement = waitForPresenceOfElementLocated(filterDropdownLocator);
        filterDropdownElement.click();
        List<WebElement> filterDropdownList = filterDropdownElement.findElements(By.xpath(patternFilterDropdownListLocator));
        for (WebElement element : filterDropdownList) {
            if (element.getText().contains(filterValue)) {
                clickElement(element);
                clickElement(waitForPresenceOfElementLocated(String.format(patternFilterLabelLocator, filterName)));
                //waitForInvisibilityOfElementLocated("//div[@data-testid='flyout-content']");
                return true;
            }
        }

        return false;
    }

    public boolean isFilterLabelExists(String filterName) {
        String filterLabelLocator = String.format(patternFilterLabelLocator, filterName);
        return (!driver.findElements(By.xpath(filterLabelLocator)).isEmpty()) ? true : false;
    }

    public List<String> getFilterDropdownList(String filterName) {
        String filterDropdownLocator = String.format(patternFilterDropdownLocator, filterName);
        WebElement filterDropdownElement = driver.findElement(By.xpath(filterDropdownLocator));
        filterDropdownElement.click();
        List<WebElement> filterDropdownList = filterDropdownElement.findElements(By.xpath(patternFilterDropdownListLocator));

        return filterDropdownList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}