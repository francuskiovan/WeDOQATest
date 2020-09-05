package tests;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wdWait;

    @Before
    public void testInit() {
        driver = new ChromeDriver();
        wdWait  = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

//    IN CASE OF MULTI BROWSER USAGE
//    @Before
//    @Parameters("browser")
//    public void testInit(String browser) {
//        if(browser.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikola\\Desktop\\DefaultProjectTest\\chromedriver.exe");
//            driver = new FirefoxDriver();
//        }
//        else if(browser.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nikola\\Desktop\\DefaultProjectTest\\geckodriver.exe");
//            driver = new FirefoxDriver();
//        }
//        else if(browser.equalsIgnoreCase("edge")){
//            System.setProperty("webdriver.edge.driver", "C:\\Users\\Nikola\\Desktop\\DefaultProjectTest\\msedgedriver.exe");
//            driver = new FirefoxDriver();
//        }
//
//        wdWait  = new WebDriverWait(driver, 10);
//        driver.manage().window().maximize();
//    }

    @After
    public void testTearDown() {
        driver.close();
        driver.quit();
    }
}