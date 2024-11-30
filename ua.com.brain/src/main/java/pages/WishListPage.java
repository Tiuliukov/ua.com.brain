package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends ParentPage{
    @FindBy(className = "delete_all_favorites_btn")
    private WebElement buttonDeleteAllFavorites;
    @FindBy(css = ".br-prof-p-title a")
    private WebElement actualProductTitle;
    @FindBy(css = ".br-prof-top-block h3")
    private WebElement titleWishListPage;
    @FindBy(css = ".col-xs-12 a[href*='/ukr/cabinet/dashboard/']")
    private WebElement buttonCabinetDashboard;


    public WishListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/cabinet/favorites/";
    }

    /**
     * Checking is 'Stores' page opened by checking URL and title is displayed
     * @return WishListPage
     */
    @Step
    public WishListPage checkIsRedirectedToWishListPage(){
        checkURL();
        Assert.assertTrue("Wish List page is not loaded", isElementDisplayed(titleWishListPage));
        return this;
    }

    /**
     * Checking is product in wish list by compare expected product title from Product DTO
     * and actual product title from page.
     * @param expectedProductTitle
     * @return WishListPage
     */
    @Step
    public WishListPage checkIsProductInWishList(String expectedProductTitle) {
        Assert.assertEquals("Wrong product title is displayed",
                expectedProductTitle, actualProductTitle.getText());
        return this;
    }

    /**
     * Remove all products which added to Wishlist by UI (by clicking on the 'DeleteAllFavorites' button)
     * @return WishListPage
     */
    @Step
    public WishListPage removeAllProductsFromWishList(){
        clickOnElement(buttonDeleteAllFavorites);
        return this;
    }

    /**
     * Check is Wish List is empty. "CabinetDashboard' button is displayed if Wish List is empty
     * @return WishListPage
     */
    @Step
    public WishListPage checkIsWishListEmpty(){
        Assert.assertTrue("CabinetDashboard button is NOT displayed",
                isElementDisplayed(buttonCabinetDashboard));
        return this;
    }
}
