package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ParentPage{
    @FindBy(className = "clear-cart")
    private WebElement buttonClearCart;
    @FindBy(css = ".br-ci-name .to_product")
    private WebElement actualProductTitle;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * @return string Relative URL "/cart"
     */
    @Override
    String getRelativeURL() {
        return "/cart";
    }

    /**
     * Checking is 'Cart' page opened by checking URL and 'ClearCart' button is displayed
     * @return CartPage
     */
    public CartPage checkIsRedirectedToCartPage(){
        checkURL();
        Assert.assertTrue("Button 'Clear Cart' is not displayed", isElementDisplayed(buttonClearCart));
        return this;
    }

    /**
     * Remove all products from Cart
     * @return CartPage
     */
    public CartPage removeAllProductsFromCart(){
        clickOnElement(buttonClearCart);
        return this;
    }

    /**
     * Checking is product in the Cart by compare expected product title from Product DTO
     * and actual product title from page.
     * @param expectedProductTitle
     * @return
     */
    public CartPage checkIsProductAddedToCart(String expectedProductTitle) {
        Assert.assertEquals("Wrong product title is displayed", expectedProductTitle, actualProductTitle.getText());
        return this;
    }
}
