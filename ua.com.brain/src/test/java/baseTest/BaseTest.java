package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPopup;
import pages.ProductPage;
import pages.StoresPage;
import pages.elements.HeaderElement;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected HomePage homePage;
    protected LoginPopup loginPopup;
    protected HeaderElement headerElement;
    protected StoresPage storesPage;
    protected ProductPage productPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage = new HomePage(webDriver);
        loginPopup = new LoginPopup(webDriver);
        headerElement = new HeaderElement(webDriver);
        storesPage = new StoresPage(webDriver);
        productPage = new ProductPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
