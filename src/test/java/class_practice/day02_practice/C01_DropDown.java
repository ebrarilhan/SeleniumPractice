package class_practice.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //implicitlyWait seleniumdan gelir
        //thread.sleep ise javadan gelir.
    }

    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        String secilenYazi = select.getFirstSelectedOption().getText();
        System.out.println("secilenYazi = " + secilenYazi);
        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String secilenYazi2 = select.getFirstSelectedOption().getText();
        System.out.println("secilenYazi2 = " + secilenYazi2);
        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String secilenYazi3 = select.getFirstSelectedOption().getText();
        System.out.println("secilenYazi3 = " + secilenYazi3);
        Thread.sleep(3000);

        // Tüm option'ları yazdırın
        List<WebElement> options = select.getOptions();
        int sayac = 1;
        for (WebElement w : options){
            System.out.println(sayac + " . option : " +w.getText());
            sayac++;
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin.
        int actualOptionsSayisi= options.size();
        int expectedOptionsSayisi = 3;
        Assert.assertEquals(expectedOptionsSayisi,actualOptionsSayisi);

    }

}
