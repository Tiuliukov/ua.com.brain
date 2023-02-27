package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends ParentPage{
    @FindBy(className = "delete_all_favorites_btn")
    private WebElement buttonDeleteAllFavorites;
    @FindBy(xpath = ".//*[@class = 'br-prof-p-title']//a")
    private WebElement actualProductTitle;
    @FindBy(xpath = ".//*[@class = 'br-wrap-block br-prof-top-block br-prof-fav']//h3")
    private WebElement titleWishListPage;
    @FindBy(xpath = ".//*[@class = 'br-wrap-block br-prof-top-block br-prof-fav']//a")
    private WebElement buttonCabinetDashboard;


    public WishListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/cabinet/favorites/";
    }

    public WishListPage checkIsRedirectedToWishListPage(){
        checkURL();
        Assert.assertTrue("Wish List page is not loaded", isElementDisplayed(titleWishListPage));
        return this;
    }

    public WishListPage checkIsProductInWishList(String expectedProductTitle) {
        checkURL();
        Assert.assertTrue("Product title is not displayed", isElementDisplayed(actualProductTitle));
        Assert.assertEquals("Wrong product title is displayed", expectedProductTitle, actualProductTitle.getText());
        return this;
    }

    public WishListPage removeAllProductsFromWishList(){
        clickOnElement(buttonDeleteAllFavorites);
        return this;
    }

    public WishListPage checkIsProductListEmpty(){
        Assert.assertTrue("buttonCabinetDashboard title is displayed", isElementDisplayed(buttonCabinetDashboard));
        return this;
    }
}
