package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CartPage;
import pages.CommonActionsWithElements;

public class CartPopup extends CommonActionsWithElements {
    @FindBy(xpath = ".//*[@class = 'modal-dialog']//button[@data-link = 'https://brain.com.ua/ukr/cart']")
    private WebElement buttonGoToCart;
    @FindBy(xpath = ".//button[@class = 'br-checkout modal-checkout']")
    private WebElement buttonCheckDelivery;

    public CartPopup(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPopup checkIsCartPopupDisplayed(){
        Assert.assertTrue("Login popup is not loaded", isElementDisplayed(buttonCheckDelivery));
        return this;
    }

    /**
     * Click on the 'GoToCart' button on 'Cart' popup
     * @return CartPage
     */
    public CartPage clickOnButtonGoToCart(){
        clickOnElement(buttonGoToCart);
        return new CartPage(webDriver);
    }

}
