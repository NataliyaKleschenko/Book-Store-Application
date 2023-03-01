package ui.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import ui.driver.WebDriverSingleton;
import ui.util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
       WebDriverSingleton.closeDriver();
    }
}
