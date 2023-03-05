package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = ".//button[@class = 'auth-popup-button']")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//div[@class = 'cart js-cart br-h-cart']")
    private WebElement buttonCart;
    @FindBy(xpath = ".//*[@class = 'user-panel-button active']")
    private WebElement buttonUserPanel;
    @FindBy(xpath = ".//li[@class = 'top-menu-list-item folder']")
    private WebElement buttonStores;
    @FindBy(xpath = ".//div[@class = 'header-bottom-in']//input[@class = 'quick-search-input']")
    private WebElement inputSearch;
    @FindBy(xpath = ".//*[@class = 'actions-item actions-wish']")
    private WebElement buttonWishList;

    private String buttonLoyaltyProgram = "Програма лояльності";
    private String DDLLoyaltyProgramItemB2C = "Про програму лояльності";
    private String itemInSearch = ".//div[@class = 'qsr-content']//*[text() = '%s']";

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * method which clicking on 'Login' button and returns LoginPopup object.
     * @return LoginPopup
     */
    public LoginPopup clickOnButtonLoggingIn() {
        clickOnElement(buttonLogin);
        return new LoginPopup(webDriver);
    }

    /**
     * method which clicking on 'Stores' button and returns StoresPage object.
     * @return StoresPage
     */
    public StoresPage clickOnButtonStores(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }

    public StoresPage clickOnButtonCart(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }

    /**
     * method which clicking on 'LoyaltyProgram' button which opens drop down list menu with items:
     * -B2C;
     * -certificates
     * @return HeaderElement
     */
    public HeaderElement clickOnDDListLoyaltyProgram(){
        clickOnElementByText(buttonLoyaltyProgram);
        return this;
    }

    /**
     * method which clicking on 'B2C' item and returns B2CPage object
     * @return B2CPage
     */
    public B2CPage clickOnDDLLoyaltyProgramItemB2C(){
        clickOnElementByText(DDLLoyaltyProgramItemB2C);
        return new B2CPage(webDriver);
    }

    /**
     * Checking is user logging in by displaying 'User Panel' button after successful login.
     * Writing successful message in log file
     * @return HeaderElement
     */
    public HeaderElement checkIsUserSuccessfullyLoggingIn (){
        Assert.assertTrue("User is not logged in", isElementDisplayed(buttonUserPanel));
        logger.info("User successfully logged In");
        return this;
    }

    /**
     * Checking is user NOT logging in by displaying 'Login' and 'User Panel' buttons.
     * Writing message in log file
     * @return HeaderElement
     */
    public HeaderElement checkIsUserNotLoggingIn(){
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonLogin));
        Assert.assertFalse("User is logged in", isElementDisplayed(buttonUserPanel));
        logger.info("User is not logged In");
        return this;
    }

    /**
     * Enter text by string in to input 'Search' on 'Header'
     * @param textSearch
     * @return HeaderElement
     */
    public HeaderElement enterTextInToInputSearch(String textSearch) {
        enterTextIntoElement(inputSearch, textSearch);
        return this;
    }

    /**
     * Click on search item by string 'title'
     * @param title
     * @return ProductPage
     */
    public ProductPage clickOnSearchResultByTitle(String title){
        clickOnElement(String.format(itemInSearch, title));
        return new ProductPage(webDriver);
    }

    /**
     * method which clicking on 'WishList' button and returns WishListPage object.
     */
    public WishListPage clickOnButtonWishList() {
        clickOnElement(buttonWishList);
        return new WishListPage(webDriver);
    }
}
