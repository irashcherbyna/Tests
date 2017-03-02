package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractBasePage {

    protected final static Logger LOG = LoggerFactory.getLogger(HomePage.class.getName());

    private final static String URL = "https://www.olx.ua/";

    @FindBy(id = "my-account-link")
    WebElement myAccountLink;

    @FindBy(css = "#topLoginLink span")
    WebElement myAccountName;

    @FindBy(id = "postNewAdLink")
    WebElement postNewAdLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        LOG.info("Directing browser to: " + URL);
        open(URL);
    }

    public void clickAccountLink() {
        LOG.info("Navigate to my account page");
        click(myAccountLink);
    }

    public void clickPostNewAdLink() {
        LOG.info("Navigate to post new advertisement page");
        click(postNewAdLink);
    }

    public boolean isLoginSuccess(String name) {
        LOG.info("Check login was successful");
        if(getText(myAccountName).equals(name)) return true;
        else return false;
    }

}
