package storesPageTests;

import baseTest.BaseTest;
import org.junit.Test;

public class StoresPageTests extends BaseTest {
    @Test
    public void TC_4_openStoresPage(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonStores()
                .checkIsRedirectedToStoresPage()
        ;
    }
}
