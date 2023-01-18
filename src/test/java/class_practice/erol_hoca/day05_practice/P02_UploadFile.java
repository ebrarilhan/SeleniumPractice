package class_practice.erol_hoca.day05_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void test() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //cerezler icin
        WebElement ifrane = driver.findElement(By.xpath("//*[@class='faktor-iframe-wrapper']"));
        driver.switchTo().frame(ifrane);
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        // "C:\Users\vysl\OneDrive\Masaüstü\logo.jpeg"
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@name='uploadfile_0']"));
//        String dosyaYolu = "\"C:\\Users\\vysl\\OneDrive\\Masaüstü\\logo.jpeg\"";

        String anaYol = System.getProperty("user.home"); //C:\\Users\\vysl\\
        String ortakYol = "\\OneDrive\\Masaüstü\\logo.jpeg";
        String dosyaYolu = anaYol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
