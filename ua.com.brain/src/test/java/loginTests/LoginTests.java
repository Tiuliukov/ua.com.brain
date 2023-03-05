package loginTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTests extends BaseTest {
    @Test
    public void TC_1_validLogin(){
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
    public void TC_2_invalidLogin(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonLoggingIn()
                .checkIsLoginPopupDisplayed()
                .fillInInputLogin(TestData.VALID_LOGIN)
                .fillInInputPassword(TestData.INVALID_PASSWORD)
                .clickOnButtonLogin()
                .getHeaderElement()
                .checkIsUserNotLoggingIn()
                ;
    }
}
