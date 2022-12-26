package ui.olx.steps;

import ui.olx.pages.HomePage;
import ui.olx.pages.ListPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListStep {
    public ListPage categoryFilter(String category) {
        Map<String, String> selectFieldMap = new HashMap<>();
        selectFieldMap.put("Stan", "Nowe");
        selectFieldMap.put("Płeć", "Męskie");

        return new CategoryStep()
                .openCategory("Moda")
                .fillFilterForm("adidas", "42", "144", selectFieldMap);
    }
}
