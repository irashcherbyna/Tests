package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdConfirmationPage extends AbstractBasePage {

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
