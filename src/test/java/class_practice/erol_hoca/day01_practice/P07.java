package class_practice.erol_hoca.day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01() throws InterruptedException {

        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[1]")).click(); //cerezler icin

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(expectedTitle.contains(actualTitle));

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisi = sonucYazisi.split(" ")[1];
        sonucSayisi=sonucSayisi.replaceAll("\\D","");
        System.out.println("sonucSayisi = " + sonucSayisi);

        int expectedResult = 10000000;
        int actualResult = Integer.parseInt(sonucSayisi);

        Assert.assertTrue(expectedResult<actualResult);

    }


    @After
    public void tearDown() {
        //Sayfayi kapatin
        driver.close();
    }




}
