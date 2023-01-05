package class_practice.day01_practice;

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

public class C02_DropDownOptions {

    // ...Exercise 2...


    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test02(){
        //1.
        driver.get("https://www.amazon.com/");

        //2.
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByValue("search-alias=baby-products-intl-ship");

        //3.
        String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);

        //4.
        List<WebElement> options = select.getOptions();
        int expectedOptionSayisi = 28;
        int actualOptionSayisi = options.size();
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

    }
}
