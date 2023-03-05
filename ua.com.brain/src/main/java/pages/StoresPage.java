package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoresPage extends ParentPage{
    @FindBy(xpath = ".//h1[@class='title']")
    private WebElement storesPageTitle;
    @FindBy(xpath = ".//button[@class = 'choice_city_button']")
    private WebElement buttonChooseCity;

    public StoresPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/shops_map/#[a-zA-Z0-9]*";
    }

    /**
     * Checking is 'Stores' page opened by checking URL by pattern
     * Checking is title and 'ChooseCity' button displayed
     * @return StoresPage
     */
    public StoresPage checkIsRedirectedToStoresPage(){
        checkURLWithPattern();
        Assert.assertTrue("Stores page title is not displayed", isElementDisplayed(storesPageTitle));
        Assert.assertTrue("'Choose city' button is not displayed on 'Stores' page",
                isElementDisplayed(buttonChooseCity));
        return this;
    }
}
