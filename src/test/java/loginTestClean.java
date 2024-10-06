import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import com.beust.jcommander.IValueValidator;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTestClean extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(loginTestClean.class);
    LoginPage login = new LoginPage();      //interface oluşturduk.birden fazla sınıfa bağlanabilmek için.
    MainPage mainPage = new MainPage();

    @Test
    public void loginSuccessful() throws InterruptedException {

        login.fillMail(email)
                .fillpassword(password)   //doğru format için alt+ cmd +l    //metod kullanırken return this dediğimiz için tekrar login.fillpassword yazmamıza gerek yok.
                .ClickLoginButton();
        sleep(3000);
        String value = mainPage.getAccountName();
        assertEquals("Hesabım", value);

    }

    @Test
    public void loginUnsuccessful() throws InterruptedException {

        login.fillMail(email)
                .fillpassword("abc")
                .ClickLoginButton();

        sleep(3000);
        String value = login.getErrorMessage();
        assertEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);

    }

    @Test
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

    @Test
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


}
