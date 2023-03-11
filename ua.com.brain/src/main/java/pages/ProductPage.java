package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.CartPopup;
import pages.elements.HeaderElement;

public class ProductPage extends ParentPage{
    @FindBy(xpath = ".//h1")
    private WebElement actualProductTitle;
    @FindBy(id = "product_code")
    private WebElement productCode;
    @FindBy(xpath = ".//*[@class = 'br-del-pr']//button[@class = 'like-link']")
    private WebElement buttonWishList;
    @FindBy(xpath = ".//*[@class = 'br-pr-cb main-order-block']")
    private WebElement buttonAddToCart;
    @FindBy(xpath = ".//*[@class = 'container br-container-main br-container-prt']")
    private WebElement productContent;

    private String RelativeURL = "";

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return RelativeURL;
    }

    /**
     * Set urlFromDTO to RelativeURL for add opportunity to compare it in checkIsRedirectedToWishListPage()
     * @param urlFromDTO
     */
    private void setRelativeURL (String urlFromDTO){
        RelativeURL = "/" + urlFromDTO;
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    /**
     * Checking is 'Product' page opened by checking URL and product code is displayed
     * @return ProductPage
     */
    public ProductPage checkIsRedirectedToProductPage(String urlFromDTO) {
        setRelativeURL(urlFromDTO);
        checkURL();
        Assert.assertTrue("Product page is not loaded", isElementDisplayed(productCode));
        return this;
    }

    /**
     * Compare expected product title from Product DTO  and actual product title from page
     * @param expectedProductTitle
     * @return ProductPage
     */
    public ProductPage checkProductTitle(String expectedProductTitle) {
        Assert.assertEquals("Wrong product title is displayed",
                expectedProductTitle.toUpperCase(), actualProductTitle.getText());
        return this;
    }

    /**
     * Click on the 'addToWishList' button on 'Product' page
     * Add product to wish list
     * @return ProductPage
     */
    public ProductPage clickOnButtonAddToWishList(){
        clickOnElement(buttonWishList);
        return this;
    }

    /**
     * Click on the 'AddToCart' button on 'Product' page
     * @return CartPopup
     */
    public CartPopup clickOnButtonAddToCart(){
        clickOnElement(buttonAddToCart);
        return new CartPopup(webDriver);
    }
}
