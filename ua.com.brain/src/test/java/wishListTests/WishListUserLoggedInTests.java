package wishListTests;

import baseTest.BaseTest;
import libs.Products;
import libs.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WishListUserLoggedInTests extends BaseTest {
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
    public void AddToWishList(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .enterTextInToInputSearch(Products.Duracell2AA.getDTO().getTitle())
                .clickOnSearchResultByTitle(Products.Duracell2AA.getDTO().getTitle())
                .checkIsRedirectedToProductPage()
                .clickOnButtonAddToWishList()
                .getHeaderElement()
                .clickOnButtonWishList()
                .checkIsRedirectedToWishListPage()
                .checkIsProductInWishList(Products.Duracell2AA.getDTO().getTitle())
                ;
    }

    @After
    public void ClearWishList(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonWishList()
                .checkIsRedirectedToWishListPage()
                .removeAllProductsFromWishList()
                .checkIsProductListEmpty()
                ;
    }
}
