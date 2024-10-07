package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    @Step("Mail adresi doldurulur")
    public LoginPage fillMail(String text){
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(text); //senaryoların içerisindeki verileri, testlerin içerisinde yönetmek için fillmail yanındaki parantezlerde parametre gönderim işini sağlayacağız.
        screenshot();
        return this;

        //iki ayrı satır yazmak yerine şöyle de yapabiliriz;
        // WebElement element = driver.findElement(By.id("login-email"));
        //element.clear();
        //element.sendKeys(text);
        //return this;
    }

    @Step("Şifre Alanı Doldurulur")
    public LoginPage fillpassword(String text){
        driver.findElement(By.name("login-password")).clear();
        driver.findElement(By.name("login-password")).sendKeys(text);
        return this;
        //iki ayrı satır yazmak yerine şöyle de yapabiliriz;
        // WebElement element = driver.findElement(By.name("login-password"));
        // element.clear();
        // element.sendKeys(text);
        // return this;

    }

    @Step("Login Butonu Tıklanır")
    public LoginPage ClickLoginButton(){

        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        return this;
    }

    @Step("Hata Mesajı ALınır")
    public String getErrorMessage(){

        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        screenshot();
        return value;
    }
}
