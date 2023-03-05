package searchTests;

import baseTest.BaseTest;
import libs.Products;
import org.junit.Test;

public class SearchTests extends BaseTest {

    @Test
    public void TC3_searchProductByTitle(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .enterTextInToInputSearch(Products.Duracell2AA.getDTO().getTitle())
                .clickOnSearchResultByTitle(Products.Duracell2AA.getDTO().getTitle())
                .checkIsRedirectedToProductPage()
                .checkProductTitle(Products.Duracell2AA.getDTO().getTitle());
    }
}
