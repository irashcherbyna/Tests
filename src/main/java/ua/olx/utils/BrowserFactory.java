package ua.olx.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static final String BROWSER_PROPERTY_KEY = "browser";

    public static WebDriver getBrowser() {
        Browsers browser;
        WebDriver driver;

        if(System.getProperty(BROWSER_PROPERTY_KEY) == null){
            browser = Browsers.FIREFOX;
        }else{
            browser = Browsers.getBrowser(System.getProperty(BROWSER_PROPERTY_KEY));
        }
        switch(browser){
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            case SAFARI:
                driver = createSafariDriver();
                break;
            case IE:
                driver = createIEDriver();
                break;
            case CHROME:
            default:
                driver = createChromeDriver();
                break;
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        return new FirefoxDriver(capabilities);
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", OperatingSystem.getChromeDriverPath());
        return new ChromeDriver();
    }

    private static WebDriver createIEDriver() {
        System.setProperty("webdriver.ie.driver", OperatingSystem.getIEDriverPath());
        return new InternetExplorerDriver();
    }

    private static WebDriver createSafariDriver() {
        return new SafariDriver();
    }

    private enum Browsers {
        FIREFOX,
        CHROME,
        SAFARI,
        IE;

        private static Browsers getBrowser(String name) throws IllegalArgumentException{
            for(Browsers browser: values()){
                if(browser.toString().equalsIgnoreCase(name)){
                    return browser;
                }
            }
            throw browserNotFound(name);
        }

        private static IllegalArgumentException browserNotFound(String outcome) {
            return new IllegalArgumentException(("Invalid browser " + outcome + ""));
        }
    }

}
