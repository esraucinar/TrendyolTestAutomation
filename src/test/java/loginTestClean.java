import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import com.beust.jcommander.IValueValidator;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Login Test Senaryoları")
public class loginTestClean extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(loginTestClean.class);
    LoginPage login = new LoginPage();      //interface oluşturduk.birden fazla sınıfa bağlanabilmek için.
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı Kullanıcı Girişi")
    public void loginSuccessful() throws InterruptedException {

        login.fillMail(email)
                .fillpassword(password)   //doğru format için alt+ cmd +l    //metod kullanırken return this dediğimiz için tekrar login.fillpassword yazmamıza gerek yok.
                .ClickLoginButton();
        sleep(3000);
        String value = mainPage.getAccountName();
        assertEquals("Hesabım", value);

    }

    @Test(description = "Başarısız Kullanıcı Girişi")
    public void loginUnsuccessful() throws InterruptedException {

        login.fillMail(email)
                .fillpassword("abc")
                .ClickLoginButton();

        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);

    }

    @Test(description = "Boş Karakter Kontrolü")
    public void requiredControl() throws InterruptedException {

        login.ClickLoginButton();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        login.fillMail(email)
                .ClickLoginButton();
        String value2 = login.getErrorMessage();
        assertEquals("Lütfen şifrenizi giriniz.", value2);
        login.fillpassword(password)
                .ClickLoginButton();
        sleep(5000);
        String value3 = mainPage.getAccountName();
        assertEquals("Hesabım", value3);
    }

    @Test(description = "Minimum ve Maximum Karakter Kontrolü")
    public void MinMaxCharacterControl() throws InterruptedException {
        login.fillMail("a")
                .fillpassword("abc")
                .ClickLoginButton();
        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
        login.fillMail(email)
                        .ClickLoginButton();
        sleep(3000);
        String value2 = login.getErrorMessage();
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value2);
        login.fillpassword(password)
                        .ClickLoginButton();
        sleep(5000);
        String value3 = mainPage.getAccountName();
        assertEquals("Hesabım", value3);
    }
    @Test(description = "Başarısız Kullanıcı Girişi2")
    public void loginUnSuccessful2() throws InterruptedException {

        login.fillMail(email)
                .fillpassword("123");
        sleep(3000);
        String value = mainPage.getAccountName();
        assertEquals("Hesabım", value);

    }

}
