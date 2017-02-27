package ua.olx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.olx.pages.fragments.advertisement.AdvertisementDetailsFragment;
import ua.olx.pages.fragments.advertisement.ContactDetailsFragment;

public class PostAd extends AbstractBasePage {

    @FindBy(id = "save")
    private WebElement saveButton;

    @FindBy(id = "footer-container")
    private WebElement footerContainer;

    private AdvertisementDetailsFragment advertisementDetailsFragment;
    private ContactDetailsFragment contactDetailsFragment;

    public PostAd(WebDriver driver) {
        super(driver);
        advertisementDetailsFragment = new AdvertisementDetailsFragment(driver);
        contactDetailsFragment = new ContactDetailsFragment(driver);
    }

    public void setAdvertisementDetails(String title, String category, String subCategory, String price,
                                        String breed, boolean isBusiness, String description) {
        LOG.info("Set advertisement details");
        advertisementDetailsFragment.inputTitle(title);
        advertisementDetailsFragment.selectCategory(category);
        advertisementDetailsFragment.selectSubCategory(subCategory);
        advertisementDetailsFragment.inputPrice(price);
        advertisementDetailsFragment.selectBreed(breed);
        advertisementDetailsFragment.selectBusinessType(isBusiness);
        advertisementDetailsFragment.inputDescription(description);
    }

    public void setContactDetailsFragment(String address, String region, String district, String name) {
        LOG.info("Set contact details");
        contactDetailsFragment.inputAddress(address);
        contactDetailsFragment.inputRegion(region);
        contactDetailsFragment.inputDistrict(district);
        contactDetailsFragment.inputName(name);
    }

    public void clickSaveButton() {
        LOG.info("Submit the form");
        scrollTo(footerContainer);
        click(saveButton);
    }

}
