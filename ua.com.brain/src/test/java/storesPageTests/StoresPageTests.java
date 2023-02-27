package storesPageTests;

import baseTest.BaseTest;
import org.junit.Test;

public class StoresPageTests extends BaseTest {
    @Test
    public void TC_3_openStoresPage(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonStores()
                .checkIsRedirectedToStoresPage()
        ;
    }
}
