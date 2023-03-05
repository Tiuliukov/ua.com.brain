package loyaltyProgramTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LoyaltyProgramTests extends BaseTest {
    @Test
    public void TC_5_openB2CPage(){
        homePage
                .openHomePage()
                .getHeaderElement()
                .clickOnDDListLoyaltyProgram()
                .clickOnDDLLoyaltyProgramItemB2C()
                .checkIsRedirectedToB2CPage()
        ;
    }
}
