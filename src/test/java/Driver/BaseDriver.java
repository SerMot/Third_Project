package Driver;

import Pages.MainPage;
import Pages.YaLinksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;



public class BaseDriver {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static YaLinksPage yaLinksPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://market.yandex.ru/");
        //String title = driver.getTitle();
        //assertTrue(title.equals("Яндекс"));
    }



    /*@AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }*/
}

