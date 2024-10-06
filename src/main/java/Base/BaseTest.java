package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Her test öncesi ve sonrası testlerde kullanacağımız işlemleri burada bulunacak.
//The process that will be used before and after each test will be placed here.
public class BaseTest extends BaseLibrary{
    public static WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
