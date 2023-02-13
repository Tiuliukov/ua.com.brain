package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void TC_1_validLogin(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnButtonLogin()
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
                .clickOnButtonLogin()
                .checkIsLoginPopupDisplayed()
                .fillInInputLogin(TestData.INVALID_LOGIN)
                .fillInInputPassword(TestData.INVALID_PASSWORD)
                .clickOnButtonLogin()
                .getHeaderElement()
                .checkIsUserNotLoggingIn()
                ;
    }
}
