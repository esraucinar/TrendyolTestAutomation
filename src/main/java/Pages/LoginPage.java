package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    public LoginPage fillMail(String text){
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(text); //senaryoların içerisindeki verileri, testlerin içerisinde yönetmek için fillmail yanındaki parantezlerde parametre gönderim işini sağlayacağız.
        return this;

        //iki ayrı satır yazmak yerine şöyle de yapabiliriz;
        // WebElement element = driver.findElement(By.id("login-email"));
        //element.clear();
        //element.sendKeys(text);
        //return this;
    }
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
    public LoginPage ClickLoginButton(){

        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).submit();
        return this;
    }
    public String getErrorMessage(){

        String value = driver.findElement(By.cssSelector("[class='message']")).getText();
        return value;
    }
}
