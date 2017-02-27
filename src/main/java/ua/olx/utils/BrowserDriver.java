package ua.olx.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.logging.Logger;

public class BrowserDriver {

    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());

    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            try {
                driver = BrowserFactory.getBrowser();
            } catch (UnreachableBrowserException e) {
                driver = BrowserFactory.getBrowser();
            } catch (WebDriverException e) {
                driver = BrowserFactory.getBrowser();
            }finally{
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    public static void close() {
        try {
            getWebDriver().close();
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }
}
