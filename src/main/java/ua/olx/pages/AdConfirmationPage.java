package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdConfirmationPage extends AbstractBasePage {

    protected final static Logger LOG = LoggerFactory.getLogger(AdConfirmationPage.class.getName());

    @FindBy(css = "#body-container p")
    private WebElement messageLocator;

    @FindBy(css = "#multipay h4")
    private WebElement adDetails;

    public AdConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getMessage() {
        LOG.info("Check message at the confirmation page");
        return getText(messageLocator);
    }

    public String getPostedAdDetails() {
        LOG.info("Check that ad was posted successfully");
        return getText(adDetails);
    }
}
