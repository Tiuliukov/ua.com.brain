package cartTests;

import baseTest.BaseTest;
import libs.Products;
import libs.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class addToCart extends BaseTest {
    @Before
    public void loginWithValidCredentials(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonLoggingIn()
                .checkIsLoginPopupDisplayed()
                .fillInInputLogin(TestData.VALID_LOGIN)
                .fillInInputPassword(TestData.VALID_PASSWORD)
                .clickOnButtonLogin()
                .getHeaderElement()
                .checkIsUserSuccessfullyLoggingIn();
    }

    @Test
    public void TC_7_AddToCart(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .enterTextInToInputSearch(Products.Duracell2AA.getDTO().getTitle())
                .clickOnSearchResultByTitle(Products.Duracell2AA.getDTO().getTitle())
                .checkIsRedirectedToProductPage(Products.Duracell2AA.getDTO().getPath())
                .clickOnButtonAddToCart()
                .checkIsCartPopupDisplayed()
                .clickOnButtonGoToCart()
                .checkIsRedirectedToCartPage()
                .checkIsProductAddedToCart(Products.Duracell2AA.getDTO().getTitle())
                ;
    }

    @After
    public void ClearCart(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonCart()
                .checkIsRedirectedToCartPage()
                .removeAllProductsFromCart()
        ;
    }
}
