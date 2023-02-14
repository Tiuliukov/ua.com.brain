package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CommonActionsWithElements;
import pages.LoginPopup;
import pages.StoresPage;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//*[@class = 'br-th-login ']")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//*[@class = 'user-panel-button active']")
    private WebElement buttonUserPanel;
    @FindBy(xpath = ".//li[@class = 'top-menu-list-item folder']")
    private WebElement buttonStores;


    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPopup clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return new LoginPopup(webDriver);
    }

    public HeaderElement checkIsUserSuccessfullyLoggingIn (){
        Assert.assertTrue("User is not logged in", isElementDisplayed(buttonUserPanel));
        logger.info("User successfully logged In");
        return this;
    }

    public HeaderElement checkIsUserNotLoggingIn(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonLogin));
        Assert.assertFalse("User is logged in", isElementDisplayed(buttonUserPanel));
        logger.info("User is not logged In");
        return this;
    }

    public StoresPage clickOnButtonStores(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }
}
