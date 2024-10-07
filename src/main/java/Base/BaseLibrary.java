package Base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import static Base.BaseTest.driver;

public class BaseLibrary extends TestData {

    @Step("{millis}süre beklenir")
    public void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    @Step("Karşılaştırma İşlemi Sağlanır")
    public void assertEquals(String actual, String expected){
        Assert.assertEquals(actual,expected);
    }


    //Alttaki kod parçacıkları, allure report için ekran görüntüsü almak için yazıldı. attachment vs kırmızı idi, import edince düzeldi.
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}

