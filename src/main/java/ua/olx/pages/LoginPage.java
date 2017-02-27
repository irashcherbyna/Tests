package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage {

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
