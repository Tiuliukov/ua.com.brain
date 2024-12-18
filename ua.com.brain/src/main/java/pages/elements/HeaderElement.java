package pages.elements;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(className = "auth-popup-button")
    private WebElement buttonLogin;
    @FindBy(css = ".cart.js-cart.br-h-cart")
    private WebElement buttonCart;
    @FindBy(className = "user-panel-button")
    private WebElement buttonUserPanel;
    @FindBy(css = ".top-menu-list-item a[href*='shops_map/']")
    private WebElement buttonStores;
    @FindBy(css = ".header-bottom-in .quick-search-input")
    private WebElement inputSearch;
    @FindBy(css = ".actions-item a[href*='favorites/']")
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
    @Step
    public LoginPopup clickOnButtonLoggingIn() {
        clickOnElement(buttonLogin);
        return new LoginPopup(webDriver);
    }

    /**
     * method which clicking on 'Stores' button and returns StoresPage object.
     * @return StoresPage
     */
    @Step
    public StoresPage clickOnButtonStores(){
        clickOnElement(buttonStores);
        return new StoresPage(webDriver);
    }

    /**
     * method which clicking on 'Cart' button and returns CartPage object.
     * @return CartPage
     */
    @Step
    public CartPage clickOnButtonCart(){
        clickOnElement(buttonCart);
        return new CartPage(webDriver);
    }

    /**
     * method which clicking on 'LoyaltyProgram' button which opens drop down list menu with items:
     * -B2C;
     * -certificates
     * @return HeaderElement
     */
    @Step
    public HeaderElement clickOnDDListLoyaltyProgram(){
        clickOnElementByText(buttonLoyaltyProgram);
        return this;
    }

    /**
     * method which clicking on 'B2C' item and returns B2CPage object
     * @return B2CPage
     */
    @Step
    public B2CPage clickOnDDLLoyaltyProgramItemB2C(){
        clickOnElementByText(DDLLoyaltyProgramItemB2C);
        return new B2CPage(webDriver);
    }

    /**
     * Checking is user logging in by displaying 'User Panel' button after successful login.
     * Writing successful message in log file
     * @return HeaderElement
     */
    @Step
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
    @Step
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
    @Step
    public HeaderElement enterTextInToInputSearch(String textSearch) {
        enterTextIntoElement(inputSearch, textSearch);
        return this;
    }

    /**
     * Click on search item by string 'title'
     * @param title
     * @return ProductPage
     */
    @Step
    public ProductPage clickOnSearchResultByTitle(String title){
        clickOnElement(String.format(itemInSearch, title));
        return new ProductPage(webDriver);
    }

    /**
     * method which clicking on 'WishList' button and returns WishListPage object.
     */
    @Step
    public WishListPage clickOnButtonWishList() {
        clickOnElement(buttonWishList);
        return new WishListPage(webDriver);
    }

}
