package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

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

    /**
     * Checking is 'Login popup' opened by checking displaying login tabs
     * @return LoginPopup
     */
    public LoginPopup checkIsLoginPopupDisplayed(){
        Assert.assertTrue("Login popup is not loaded", isElementDisplayed(loginTabs));
        return this;
    }

    /**
     * Filling input 'Login' field by string parameter 'userLogin'
     * @param userLogin
     * @return LoginPopup
     */
    public LoginPopup fillInInputLogin(String userLogin) {
        enterTextIntoElement(inputLogin, userLogin);
        return this;
    }

    /**
     * Filling input 'Password' field by string parameter 'userPassword'
     * @param userPassword
     * @return LoginPopup
     */
    public LoginPopup fillInInputPassword(String userPassword) {
        enterTextIntoElement(inputPassword, userPassword);
        return this;
    }

    /**
     * Click on 'Login' button on 'Login' popup
     * @return LoginPopup
     */
    public LoginPopup clickOnButtonLogin (){
        clickOnElement(buttonLogin);
        return this;
    }
}
