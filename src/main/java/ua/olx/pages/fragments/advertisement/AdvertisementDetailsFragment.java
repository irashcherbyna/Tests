package ua.olx.pages.fragments.advertisement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.olx.pages.AbstractBasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AdvertisementDetailsFragment extends AbstractBasePage {

    @FindBy(id = "add-title")
    private WebElement titleInput;

    @FindBy(id = "category-breadcrumb-container")
    private WebElement categorySelect;

    @FindBy(id = "choose-category-button")
    private WebElement changeCategoryButton;

    @FindBy(className = "paramPriceInput")
    private WebElement priceInput;

    @FindBy(linkText = "Выбрать")
    private WebElement chooseBreedSelect;

    @FindBy(id = "targetid_private_business")
    private WebElement chooseBusinessType;

    @FindBy(id = "add-description")
    private WebElement inputDescription;

    public AdvertisementDetailsFragment(WebDriver driver) {
        super(driver);
    }

    public void inputTitle(String title) {
        setValue(titleInput, title);
    }

    public void selectCategory(String category) {
        click(categorySelect);
        click(findElement(By.linkText(category)));
    }

    public void selectSubCategory(String subCategory) {
        click(findElement(By.linkText(subCategory)));
        assertThat(elementToBeClickable(changeCategoryButton));
    }

    public void inputPrice(String price) {
        setValue(priceInput, price);
    }

    public void selectBreed(String breed) {
        click(chooseBreedSelect);
        click(findElement(By.linkText(breed)));
    }

    public void selectBusinessType(boolean isBusiness) {
        click(chooseBusinessType);

        if(isBusiness == true) {
            click(findElement(By.linkText("Бизнес")));
        }
        else {
            click(findElement(By.linkText("Частное лицо")));
        }
    }

    public void inputDescription(String description) {
        setValue(inputDescription, description);
    }

}
