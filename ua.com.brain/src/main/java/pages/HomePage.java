package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
         return "/";
    }

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    /**
     * Open Home page by base URL
     * @return HomePage
     */
    @Step
    public HomePage openHomePage(){
        try {
            webDriver.get(base_url +  getRelativeURL() );
            logger.info("LoginPage was opened");
        } catch (Exception e) {
            Assert.fail("Can not open Login Page" + e);
        }
        return  this;
    }
}
