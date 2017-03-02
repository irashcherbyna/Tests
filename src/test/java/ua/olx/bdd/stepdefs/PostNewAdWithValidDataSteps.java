package ua.olx.bdd.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ua.olx.pages.AdConfirmationPage;
import ua.olx.pages.HomePage;
import ua.olx.pages.LoginPage;
import ua.olx.pages.PostAdPage;
import ua.olx.utils.BrowserDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostNewAdWithValidDataSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private PostAdPage postAdPage;
    private AdConfirmationPage adConfirmationPage;

    private String title;
    private String category;
    private String subCategory;
    private String price;
    private String breed;
    private boolean isBusiness;
    private String description;

    private String address;
    private String region;
    private String district;
    private String name;

    public PostNewAdWithValidDataSteps() {
        homePage = new HomePage(BrowserDriver.getWebDriver());
        loginPage = new LoginPage(BrowserDriver.getWebDriver());
        postAdPage = new PostAdPage(BrowserDriver.getWebDriver());
        adConfirmationPage = new AdConfirmationPage(BrowserDriver.getWebDriver());
    }

    @Given("^I (?:am on|visit) the homepage$")
    public void iAmOnTheHomePage() {
        homePage.visit();
    }

    @And("^I log in using the email '(.*?)' and password '(.*?)'$")
    public void iLogInUsingTheLoginAndPassword(String email, String password) {
        homePage.clickAccountLink();
        loginPage.login(email, password);
    }

    @When("^I navigate to the add advertisement page$")
    public void iNavigateToTheAddAdvertisementPage() {
        homePage.clickPostNewAdLink();
    }

    @And("^enter valid information to the advertisement details fields$")
    public void enterValidInformationToTheAdvertisementDetailsFields(DataTable adDetails) {
        List<List<String>> table = adDetails.raw();

        title = table.get(1).get(0);
        category = table.get(1).get(1);
        subCategory = table.get(1).get(2);
        price = table.get(1).get(3);
        breed = table.get(1).get(4);
        isBusiness = Boolean.parseBoolean(table.get(1).get(5));
        description = table.get(1).get(6);

        postAdPage.setAdvertisementDetails(title, category, subCategory, price, breed, isBusiness, description);
    }

    @And("^valid information to the contact details fields$")
    public void validInformationToTheContactDetailsFields(DataTable contactDetails) {
        List<List<String>> table = contactDetails.raw();

        address = table.get(1).get(0);
        region = table.get(1).get(1);
        district = table.get(1).get(2);
        name = table.get(1).get(3);

        postAdPage.setContactDetailsFragment(address, region, district, name);
    }

    @And("^I submit the form$")
    public void iSubmitTheForm() {
        postAdPage.clickSaveButton();
    }

    @Then("^I should see the confirmation page with successfully message$")
    public void iShouldSeeTheConfirmationPageWithSuccessfullyMessage() {
        assertEquals("Ваше объявление принято!", adConfirmationPage.getMessage());
    }

    @And("^posted ad details$")
    public void postedAdDetails() {
        assertEquals(title, adConfirmationPage.getPostedAdDetails());
    }
}
