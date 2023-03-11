package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CartPage;
import pages.HomePage;
import pages.elements.LoginPopup;
import pages.ProductPage;
import pages.StoresPage;
import pages.elements.HeaderElement;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected HomePage homePage;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Before
    public void setUp(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(ops);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configProperties.TIME_FOR_DEFAULT_WAIT()));
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
