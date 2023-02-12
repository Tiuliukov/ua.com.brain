package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPopup;
import pages.elements.HeaderElement;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected HomePage homePage;
    protected LoginPopup loginPopup;
    protected HeaderElement headerElement;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(webDriver);
        loginPopup = new LoginPopup(webDriver);
        headerElement = new HeaderElement(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
