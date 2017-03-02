package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractBasePage {

    protected final static Logger LOG = LoggerFactory.getLogger(LoginPage.class.getName());

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "userPass")
    private WebElement userPasswordInput;

    @FindBy(id = "se_userLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        LOG.info("Logging in with email: " + email + " and password: " + password);
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
        LOG.info("Login submitted");
    }

    private void inputEmail(String email) {
        setValue(userEmailInput, email);
    }

    private void inputPassword(String password) {
        setValue(userPasswordInput, password);
    }

    private void clickLoginButton() {
        click(loginButton);
    }

}
