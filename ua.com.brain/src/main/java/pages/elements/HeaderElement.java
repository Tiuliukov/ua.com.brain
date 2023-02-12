package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPopup;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(className = "br-th-login")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//*[@class = 'user-panel-button active']")
    private WebElement buttonUserPanel;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPopup clickOnButtonLogin() {
        clickOnElement(buttonLogin);
        return new LoginPopup(webDriver);
    }

    public HeaderElement checkIsUserSuccessfullyLoggingIn (){
        isElementDisplayed(buttonUserPanel);
        return this;
    }
}
