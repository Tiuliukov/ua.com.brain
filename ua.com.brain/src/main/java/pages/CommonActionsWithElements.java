package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    private String desiredElement = ".//*[text() = '%s']";

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    /**
     * Clicking on any element by parameter 'webElement'
     * @param webElement
     */
    protected void clickOnElement (WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String elementName = getElementName(webElement);
            webElement.click();
            logger.info(elementName + " element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Clicking on any element by xpath
     * @param xpath
     */
    protected void clickOnElement (String xpath){
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Clicking on any element by parameter String 'textOfElement'
     * @param textOfElement
     */
    protected void clickOnElementByText(String textOfElement){
        try {
            WebElement webElement = findElementByText(textOfElement);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Enter text by parameter 'text' in any element by parameter 'webElement'
     * @param webElement
     * @param text
     */
    protected void enterTextIntoElement (WebElement webElement, String text){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            String elementName = getElementName(webElement);
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to element " + elementName);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * checking is element displayed by parameter 'webElement'
     * Used waiter TIME_FOR_EXPLICIT_WAIT_LOW with visibility condition
     * write message in log
     * @param webElement
     * @return
     */
    protected boolean isElementDisplayed(WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            boolean state = webElement.isDisplayed();
            String message;
            String elementName = getElementName(webElement);
            if (state){
                message = elementName + " element is displayed";
            } else {
                message = elementName + " element is not displayed";
            }
            logger.info(message);
            return state;
        }catch (Exception e){
            logger.info("element is not displayed");
            return false;
        }
    }

    /**
     * Find element by text
     * Used waiter TIME_FOR_EXPLICIT_WAIT_LOW with visibility condition
     * @param textOfElement
     * @return webElement
     */
    protected WebElement findElementByText (String textOfElement){
        try {
            WebElement webElement;
            webElement = webDriver.findElement(By.xpath(String.format(desiredElement, textOfElement)));
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            return webElement;
        }catch (Exception e) {
            printErrorAndStopTest(e);
            return null;                        //refactor null
        }
    }

    /**
     * Get String Element name from Accessibility by parameter webElement
     * @param webElement
     * @return String 'AccessibleName'
     */
    private String getElementName(WebElement webElement){
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Exception Handling
     * @param e
     */
    protected void printErrorAndStopTest(Exception e){
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
}
