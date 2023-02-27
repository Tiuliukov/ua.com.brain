package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements{
    protected String base_url = "https://brain.com.ua/ukr";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    abstract String getRelativeURL();

    protected  void checkURL (){
        Assert.assertEquals("Invalid page", base_url + getRelativeURL(), webDriver.getCurrentUrl());
    }

    protected void checkURLContainsRelative(){
        Assert.assertThat("Invalid page", webDriver.getCurrentUrl(), CoreMatchers.containsString(base_url + getRelativeURL()));
    }

    protected void checkURLWithPattern(){
        String actualURL = webDriver.getCurrentUrl();
        Assert.assertTrue("\nActual URL " + actualURL + "\n" + "Expected URL " + base_url + getRelativeURL() + "\n",
                actualURL.matches(base_url + getRelativeURL()));
    }
}
