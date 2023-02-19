package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends ParentPage{
    @FindBy(xpath = ".//h1")
    private WebElement actualProductTitle;
    @FindBy(id = "product_code")
    private WebElement productCode;


    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage checkIsRedirectedToProductPage() {
        Assert.assertTrue("Product page is not loaded", isElementDisplayed(productCode));
        return this;
    }

    public ProductPage checkProductTitle(String expectedProductTitle) {

        Assert.assertEquals("Wrong product title is displayed", expectedProductTitle.toUpperCase(), actualProductTitle.getText());
        return this;
    }
}
