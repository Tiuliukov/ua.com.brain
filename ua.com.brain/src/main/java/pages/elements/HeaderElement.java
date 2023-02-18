package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.B2CPage;
import pages.CommonActionsWithElements;
import pages.LoginPopup;
import pages.StoresPage;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//*[@class = 'br-th-login ']")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//div[@class = 'cart js-cart br-h-cart']")
    private WebElement buttonCart;
    @FindBy(xpath = ".//*[@class = 'user-panel-button active']")
    private WebElement buttonUserPanel;
    @FindBy(xpath = ".//li[@class = 'top-menu-list-item folder']")
    private WebElement buttonStores;

    private String buttonLoyaltyProgram = "Програма лояльності";
    private String DDLLoyaltyProgramItemB2C = "Про програму лояльності";

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPopup clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return new LoginPopup(webDriver);
    }

    public StoresPage clickOnButtonStores(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }

    public StoresPage clickOnButtonCart(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }

    public HeaderElement clickOnDDListLoyaltyProgram(){
        clickOnElementByText(buttonLoyaltyProgram);
        return this;
    }

    public B2CPage clickOnDDLLoyaltyProgramItemB2C(){
        clickOnElementByText(DDLLoyaltyProgramItemB2C);
        return new B2CPage(webDriver);
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
}
