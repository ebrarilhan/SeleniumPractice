package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q08_Zeynel {

    WebDriver driver;
    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("before");
    }
    @Test
    public void test01() throws InterruptedException {
        //2. Navigate to url 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        System.out.println("test01");

        //3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

        //4. Click on 'Products' button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='title text-center']")).click();

        //6. The products list is visible
        WebElement urunlerListesi = driver.findElement(By.xpath("//*[@class='title text-center']"));
        System.out.println(urunlerListesi.isDisplayed());

        //7. Click on 'View Product' of first product
        Thread.sleep(1000);
        WebElement ilkUrunSec = driver.findElement(By.xpath("(//*[@href='/product_details/1'])[1]"));
        ilkUrunSec.click();

        //8. User is landed to product detail page
        Thread.sleep(1000);
        String actualDetailPageUrl = driver.getCurrentUrl();
        String expectedDetailPageUrl = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(expectedDetailPageUrl, actualDetailPageUrl);

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        driver.navigate().refresh();
        WebElement detailPageLast = driver.findElement(By.xpath("//*[@class='product-information']"));
        System.out.println(detailPageLast.isDisplayed());
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
