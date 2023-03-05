package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class B2CPage extends ParentPage{
    @FindBy(id = "title")
    private WebElement B2CPageTitle;

    public B2CPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * @return string Relative URL "/brainup/b2c"
     */
    @Override
    String getRelativeURL() {
        return "/brainup/b2c";
    }

    /**
     * Checking is 'B2CPage' opened by checking displaying page title
     * @return B2CPage
     */
    public B2CPage checkIsRedirectedToB2CPage(){
        checkURL();
        Assert.assertTrue("B2C page title is not displayed", isElementDisplayed(B2CPageTitle));
        return this;
    }
}
