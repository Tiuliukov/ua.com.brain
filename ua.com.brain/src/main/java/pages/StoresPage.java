package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoresPage extends ParentPage{
    @FindBy(id = ".//h1[@class='title']")
    private WebElement storesPageTitle;
    @FindBy(id = ".//button[@class = 'choice_city_button']")
    private WebElement buttonChooseCity;

    public StoresPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StoresPage checkIsRedirectedToStoresPage(){
        Assert.assertTrue("Stores page title is not displayed", isElementDisplayed(storesPageTitle));
        Assert.assertTrue("'Choose city' button is not displayed on 'Stores' page", isElementDisplayed(buttonChooseCity));
        return this;
    }
}
