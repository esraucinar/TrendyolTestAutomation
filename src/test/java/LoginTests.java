import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.manage().window().maximize();
    }
//burada metodu sınıfı kendimiz oluşturduk.
    @Test
    public void loginSuccessful() throws InterruptedException {

        driver.findElement(By.id("login-email")).sendKeys("movef62876@rinseart.com");
        driver.findElement(By.name("login-password")).sendKeys("Istanbul1453");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit(); //click'te olabilir, denemek lazım.
        Thread.sleep(3000);
        String value= driver.findElement(By.cssSelector("[class='link account-user'] p")).getText(); //giriş yapıp yapmadığımızı görebilmek için metni value değerini atamasını istedik.
        System.out.println(value);
        Assert.assertEquals("Hesabım",value);
    }

    @Test
    public void loginUnsuccessful() throws InterruptedException {

        driver.findElement(By.id("login-email")).sendKeys("movef62876@rinseart.com");
        driver.findElement(By.name("login-password")).sendKeys("random");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit(); //click'te olabilir, denemek lazım.
        Thread.sleep(3000);
        String value= driver.findElement(By.cssSelector("[class='message']")).getText(); //giriş yapıp yapmadığımızı görebilmek için metni value değerini atamasını istedik.
        System.out.println(value);
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.",value);
    }

    @Test
    public void requiredControl() throws InterruptedException {

        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String value= driver.findElement(By.cssSelector("[class='message']")).getText(); //giriş yapıp yapmadığımızı görebilmek için metni value değerini atamasını istedik.
        System.out.println(value);
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.",value);
        driver.findElement(By.id("login-email")).sendKeys("movef62876@rinseart.com");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        String value2= driver.findElement(By.cssSelector("[class='message']")).getText();
        System.out.println(value2);
        Assert.assertEquals("Lütfen şifrenizi giriniz.",value2);
        driver.findElement(By.name("login-password")).sendKeys("Istanbul1453");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit(); //click'te olabilir, denemek lazım.
        Thread.sleep(3000);
        String value3= driver.findElement(By.cssSelector("[class='link account-user'] p")).getText(); //giriş yapıp yapmadığımızı görebilmek için metni value değerini atamasını istedik.
        System.out.println(value3);
        Assert.assertEquals("Hesabım",value3);
    }

    @Test
    public void MinMaxCharacterControl() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys("a");
        driver.findElement(By.name("login-password")).sendKeys("A");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String value= driver.findElement(By.cssSelector("[class='message']")).getText(); //giriş yapıp yapmadığımızı görebilmek için metni value değerini atamasını istedik.
        System.out.println(value);
        Assert.assertEquals("Lütfen geçerli bir e-posta adresi giriniz.",value);
        driver.findElement(By.id("login-email")).clear();           //cmd d ile bir üstü bir alt satıra kopyalayabilirsin.
        driver.findElement(By.id("login-email")).sendKeys("movef62876@rinseart.com");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(3000);
        String value2= driver.findElement(By.cssSelector("[class='message']")).getText();
        System.out.println(value2);
        Assert.assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.",value2);
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys("Istanbul1453");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit(); //click'te olabilir, denemek lazım.
        Thread.sleep(3000);
        String value3= driver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        System.out.println(value3);
        Assert.assertEquals("Hesabım",value3);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //testimizi başlatmak ve durdurmak için testNG kullanıyoruz. bununiçin bir @ ifadesi ile annatations açıyoruz. yani açıklama










}
