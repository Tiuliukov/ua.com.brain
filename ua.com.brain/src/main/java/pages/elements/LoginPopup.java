package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.ParentPage;

public class LoginPopup extends CommonActionsWithElements {
    @FindBy(id = "modal-login-phone-field")
    private WebElement inputLogin;
    @FindBy(id = "modal-login-password-field")
    private WebElement inputPassword;
    @FindBy(xpath = ".//*[@class = 'tab-pane active']//button[@class = 'br-login-submit']")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//*[@class = 'br-login-tabs']")
    private WebElement loginTabs;

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public LoginPopup(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public LoginPopup checkIsLoginPopupDisplayed(){
        Assert.assertTrue("Login popup is not loaded", isElementDisplayed(loginTabs));
        return this;
    }

    public LoginPopup fillInInputLogin(String userLogin) {
        enterTextIntoElement(inputLogin, userLogin);
        return this;
    }

    public LoginPopup fillInInputPassword(String userPassword) {
        enterTextIntoElement(inputPassword, userPassword);
        return this;
    }

    public LoginPopup clickOnButtonLogin (){
        clickOnElement(buttonLogin);
        return this;
    }
}
