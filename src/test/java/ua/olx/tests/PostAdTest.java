package ua.olx.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ua.olx.pages.HomePage;
import ua.olx.pages.LoginPage;
import ua.olx.pages.PostAd;
import ua.olx.pages.AdConfirmationPage;

public class PostAdTest extends AbstractBaseTest {

    private final static String USER_NAME = "shcherbyna.ira";
    private final static String EMAIL = "shcherbyna.ira@gmail.com";
    private final static String PASSWORD = "password";

    private final static String TITLE = "Бенгальские котики";
    private final static String CATEGORY = "Животные";
    private final static String SUB_CATEGORY = "Кошки";
    private final static String PRICE = "10000";
    private final static String BREED = "Бенгальская";
    private final static boolean IS_BUSINESS = false;
    private final static String DESCRIPTION = "Очаровательные котята, окрас : розетка на золоте " +
            "(очень контрастные и яркие морфы). Забирать деток уже можно, подрастают котята к Николаю и Новому году. " +
            "Котята от титулованных родителей, папа трех кратный чемпион, мама двух кратный. " +
            "Котята, очень славные, толстенькие, сбитенькие, здоровенькие, игривые. " +
            "Бенгалы сами по себе отличаются, добродушным и порядочным характером, чистоплотностью и ласковостью.";

    private final static String ADDRESS = "Киев";
    private final static String REGION = "Киев, Киевская область";
    private final static String DISTRICT = "Голосеевский";
    private final static String NAME = "Ирина";

    private HomePage homePage;
    private LoginPage loginPage;
    private PostAd postAd;
    private AdConfirmationPage adConfirmationPage;

    public PostAdTest() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        postAd = new PostAd(driver);
        adConfirmationPage = new AdConfirmationPage(driver);
    }

    @Test
    public void testPostAd() {
        homePage.visit();
        homePage.clickAccountLink();

        loginPage.login(EMAIL, PASSWORD);
        assertTrue(homePage.isLoginSuccess(USER_NAME));

        homePage.clickPostNewAdLink();

        postAd.setAdvertisementDetails(TITLE, CATEGORY, SUB_CATEGORY, PRICE, BREED, IS_BUSINESS, DESCRIPTION);
        postAd.setContactDetailsFragment(ADDRESS, REGION, DISTRICT, NAME);
        postAd.clickSaveButton();

        assertEquals("Ваше объявление принято!", adConfirmationPage.getMessage());
        assertEquals(TITLE, adConfirmationPage.getPostedAdDetails());
    }
}
