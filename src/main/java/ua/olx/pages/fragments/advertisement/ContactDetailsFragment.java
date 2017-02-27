package ua.olx.pages.fragments.advertisement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.olx.pages.AbstractBasePage;

public class ContactDetailsFragment extends AbstractBasePage{

    @FindBy(id = "mapAddress")
    private WebElement addressInput;

    @FindBy(id = "add-person")
    private WebElement nameInput;

    public ContactDetailsFragment(WebDriver driver) {
        super(driver);
    }

    public void inputAddress(String address) {
        setValue(addressInput, address);
    }

    public void inputRegion(String region) {
        hover(By.linkText(region));
    }

    public void inputDistrict(String district) {
        click(By.linkText(district));
    }

    public void inputName(String name) {
        setValue(nameInput, name);
    }

}
