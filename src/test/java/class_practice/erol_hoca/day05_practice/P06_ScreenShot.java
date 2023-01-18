package class_practice.erol_hoca.day05_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P06_ScreenShot extends TestBase {

    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    String tarih;

    @Test
    public void test() throws IOException, InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String windowHandle = driver.getWindowHandle();

        //Tüm sayfanın resmini alalım.
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        /*
        FILEUTILS CLASS'I FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHODLAR ICERIR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
         */

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım.
        Thread.sleep(6000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(windowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Arama sonucunun resmini alalım
        Thread.sleep(6000);
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
    }
}
