package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class ProductPage extends ParentPage{
    @FindBy(xpath = ".//h1")
    private WebElement actualProductTitle;
    @FindBy(id = "product_code")
    private WebElement productCode;
    @FindBy(xpath = ".//*[@class = 'br-del-pr']//button[@class = 'like-link']")
    private WebElement buttonWishList;

    private HeaderElement headerElement = new HeaderElement(webDriver);

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public ProductPage checkIsRedirectedToProductPage() {
        Assert.assertTrue("Product page is not loaded", isElementDisplayed(productCode));
        return this;
    }

    public ProductPage checkProductTitle(String expectedProductTitle) {
        Assert.assertEquals("Wrong product title is displayed", expectedProductTitle.toUpperCase(), actualProductTitle.getText());
        return this;
    }

    public ProductPage clickOnButtonAddToWishList(){
        clickOnElement(buttonWishList);
        return this;
    }
}
