package class_practice.erol_hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

     /*
    -"amazon.com" adresine gidelim
    -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    -title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
    -Ardindan "trendyol.com" adresine gidelim
    -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    -Bi onceki web sayfamiza geri donelim
    -sayfayi yenileyelim
    -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
     */

    public static void main(String[] args) {


            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //1.
            driver.get("https://amazon.com");

            //2.
            String actualTitle = driver.getTitle();
            String actualUrl = driver.getCurrentUrl();
            System.out.println("sayfa basligi : " + actualTitle);
            System.out.println("sayfa url : " + actualUrl);

            //3.
            Assert.assertFalse(actualTitle.contains("Spend") && actualUrl.contains("Spend"));

            //4.
            driver.get("https://trendyol.com");

            //5.
            String trendyolTitle = driver.getTitle();
            Assert.assertFalse(trendyolTitle.contains("Sitesi"));

            //6.
            driver.navigate().back();

            //7.
            driver.navigate().refresh();

            //8.
            driver.navigate().forward();

            driver.quit();// Birden fazla sayfada çalışılmış ise quit() methodu kullanılır









    }
}
