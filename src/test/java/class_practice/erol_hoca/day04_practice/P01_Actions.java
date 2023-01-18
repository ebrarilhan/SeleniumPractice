package class_practice.erol_hoca.day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01_Actions extends TestBase {

    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void test() throws InterruptedException {

        // http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        // Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10,-10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }

        actions.release().build().perform();

        // Çizimden sonra clear butonuna basalım
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }
}
