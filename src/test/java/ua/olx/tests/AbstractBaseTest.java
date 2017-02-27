package ua.olx.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import ua.olx.utils.BrowserDriver;

public abstract class AbstractBaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = BrowserDriver.getWebDriver();
    }

    @AfterClass
    public static void tearDown() {
        BrowserDriver.close();
    }

}
