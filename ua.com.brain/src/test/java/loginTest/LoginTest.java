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
                .fillInInputLogin(TestData.VALID_LOGIN)
                .fillInInputPassword(TestData.VALID_PASSWORD)
                .clickOnButtonLogin()
                .getHeaderElement()
                .checkIsUserSuccessfullyLoggingIn()
                ;
    }

}
