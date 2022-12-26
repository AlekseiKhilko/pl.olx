package ui.olx.data;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "fieldList")
    public static Object[] provideFieldList() {
        return new Object[]{"Cena", "Stan", "Płeć"};
    }

    @DataProvider(name = "invalidRequest")
    public static Object[] provideInvalidRequest() {
        return new Object[]{"rgregrgr", "%%", "llnb"};
    }
}