package ua.olx.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class AbstractBasePage {

    protected final static Logger LOG = LoggerFactory.getLogger(AbstractBasePage.class.getName());

    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean isDisplayed(WebElement element) {
        waitForElement(element);
        return element.isDisplayed();
    }

    protected void open(String url){
        driver.get(url);
    }

    protected void hover(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(locator));
        action.perform();
    }

    protected void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(element));
        action.perform();
    }

    protected void setValue(WebElement element, String value) {
        waitForElement(element);
        element.clear();
        element.sendKeys(value);
    }

    protected void scrollTo(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", waitForElement(element));
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void click(WebElement element) {
        waitForElement(element).click();
    }

    protected String getText(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(driver, 10)).until(condition);
    }

    protected WebElement waitForElement(WebElement element){
        return (new WebDriverWait(driver, 10)).until(visibilityOf(element));
    }

    protected WebElement findElement(By locator){
        assertThat(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        assertThat(visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

}
