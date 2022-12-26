package ui.olx.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ui.olx.pages.CategoryPage;
import ui.olx.pages.ListPage;
import ui.olx.steps.CategoryStep;
import ui.olx.data.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryTest extends AbstractTest {
    @AfterMethod
    public void tearDown() {
        //DriverSingleton.closeDriver();
    }

    @Test
    public void categoryTest() {
        new CategoryStep().openCategory("Moda");
    }

    @Test
    public void listFilterLabelExistsTest() {
        ListPage listPage = new CategoryStep().openCategory("Moda");

        Assert.assertTrue(listPage.isFilterLabelExists("Cena"));
        Assert.assertTrue(listPage.isFilterLabelExists("Stan"));
        Assert.assertTrue(listPage.isFilterLabelExists("Płeć"));
    }
    @Test
    public void categoryDropdownStanListTest() {
        List<String> actualList = new CategoryStep().openCategory("Moda")
                .getFilterDropdownList("Stan");
        /*
        List<String> expectedList = Arrays.asList("Używane", "Nowe", "Pozostałe");
        actualList.remove("Wszystkie");
        Assert.assertEquals(actualList, expectedList);
         */
        Assert.assertTrue(actualList.contains("Używane"));
        Assert.assertTrue(actualList.contains("Nowe"));
        Assert.assertTrue(actualList.contains("Pozostałe"));
    }

    @Test
    public void categoryDropdownPlacListTest() {
        List<String> actualList = new CategoryStep().openCategory("Moda")
                .getFilterDropdownList("Płeć");

        Assert.assertTrue(actualList.contains("Męskie"));
        Assert.assertTrue(actualList.contains("Damskie"));
    }
}