package ui.olx.steps;

import ui.olx.pages.CategoryPage;
import ui.olx.pages.HomePage;
import ui.olx.pages.ListPage;

public class CategoryStep  {
    public ListPage openCategory(String category){
        return new HomePage()
                .openPage()
                .openCategoryPage()
                .clickCategory(category)
                .clickSubCategory(category)
                .waitLoad();
    }
}
