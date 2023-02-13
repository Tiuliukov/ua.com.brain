package pages;

import org.junit.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait10;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void clickOnElement (WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void enterTextIntoElement (WebElement webElement, String text){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            boolean state = webElement.isDisplayed();
            String message;
            if (state){
                message = "Element is displayed";
            } else {
                message = "Element is not displayed";
            }
            logger.info(message);
            return state;
        }catch (Exception e){
            logger.info("element is not displayed");
            return false;
        }
    }

    protected void printErrorAndStopTest(Exception e){
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
}
