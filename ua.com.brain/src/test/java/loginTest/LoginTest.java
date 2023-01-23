package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void validLogin(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://brain.com.ua/");

        WebElement openLoginPopupButton = webDriver.findElement(By.xpath(".//button[@class = 'auth-popup-button']"));
        openLoginPopupButton.click();

        WebElement inputPhoneField = webDriver.findElement(By.xpath(".//input[@id = 'modal-login-phone-field']"));
        inputPhoneField.sendKeys("+38 (098) 501-97-80");

        WebElement inputUserPassword = webDriver.findElement(By.xpath(".//input[@id = 'modal-login-password-field']"));
        inputUserPassword.clear();
        inputUserPassword.sendKeys("36075354");

        WebElement buttonSignIn = webDriver
                .findElement(By.xpath(".//div[@class = 'tab-pane active']//button[@class = 'br-login-submit']"));
        buttonSignIn.click();

        Assert.assertTrue("'User Panel' is not displayed", isUserPanelDisplayed());

        webDriver.quit();
        System.out.println("browser was closed");
    }

    private boolean isUserPanelDisplayed(){
        try {
            return webDriver.findElement(By.xpath(".//div[@class = 'user-panel-wrap js-login-popup']")).isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }
}
