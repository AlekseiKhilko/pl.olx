package ui.olx.test;

import ui.olx.driver.DriverSingleton;
import ui.olx.utils.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class AbstractTest {

    @BeforeTest
    public void logIn() {
        //AuthorizeStep.logIn(UserCreator.createDefaultUser());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}