package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Q25 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException, AWTException {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com/");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actual = driver.getCurrentUrl();
        String expected = "https://automationexercise.com/";
        Assert.assertEquals(expected, actual);
        //4. Sayfayı aşağıya doğru kaydırın
        //1=One Way
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        //kAYNAK ADRES:https://tur.delavaio.com/334235-page-scroll-up-or-down-YTUGWA
        //2=Two Way
//        Actions actions = new Actions(driver);
//       actions
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN)
//               .sendKeys(Keys.PAGE_DOWN).perform();
//       Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        //5. 'ABONELİK'in görünür olduğunu doğrulayın
        WebElement SUBSCRIPTION = driver.findElement(By.xpath("(//h2)[82]"));
        Assert.assertTrue(SUBSCRIPTION.isDisplayed());
        Thread.sleep(2000);
        System.out.println(SUBSCRIPTION.isDisplayed());
        //6. Yukarı doğru hareket etmek için sağ alt taraftaki oka tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-angle-up']")).click();
        //7. Sayfanın yukarı kaydırıldığını ve 'Tam Teşekküllü uygulama web sitesi' olduğunu doğrulayın.
        WebElement scrolledUp = driver.findElement(By.xpath("(//h2)[1]"));
        //Otomasyon Mühendisleri için metin ekranda görünür
        System.out.println("AutomationExercise\n" +
                "Full-Fledged practice website for Automation Engineers");
        System.out.println(scrolledUp.isDisplayed());
    }
    @AfterClass
    public static void teardown(){
        // driver.close();
    }
}
