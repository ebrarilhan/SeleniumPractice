package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q14_Fatih {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test03() throws InterruptedException {

//   3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";

        Assert.assertEquals(expectedUrl, actualUrl);

    }
    @Test
    public  void  test04() throws InterruptedException {
//            4. Sepete ürün ekleyin

        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        Thread.sleep(3000);

    }

    @Test
    public   void test05() throws InterruptedException {

//        5. 'Sepet' düğmesine tıklayın

        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();
//        Thread.sleep(4000);

//    }

//    @Test
//    public  void test04() throws InterruptedException {

//   6. Sepet sayfasının görüntülendiğini doğrulayın

        WebElement viewCart = driver.findElement(By.xpath("//*[@class='active']"));
        System.out.println("View Cart :" + viewCart.isDisplayed());
        Thread.sleep(4000);

    }
    @Test
    public   void test07() throws InterruptedException {

        //    7. Ödeme İşlemine Devam Et'i tıklayın

        driver.findElement(By.xpath("//*[@class='col-sm-6']")).click();
        Thread.sleep(5000);

    }
    @Test
    public   void test08() throws InterruptedException {

        //    8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın

        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        Thread.sleep(4000);



        // driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
        driver.findElement(By.xpath("//*[@type='email']")).
                sendKeys("fatih.@gmail.com",
                        Keys.TAB, "123fatih", Keys.TAB, Keys.ENTER);

    }
     /*
   NOTE: 9.cu madde de üye kayıtı yapılıyor. Bir kere 9 u calıştırdım sonra sadece üye girişi (Login) kısmını calıştırdım
   burayı yoruma aldım, tekrar tekrar mail degiştirmeyeyim diye cunku her girişte farklı bir mail girmak gerekiyor.

    @Test
    public  void test09() throws InterruptedException {

        //    9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
//    driver.findElement(By.xpath("//*[@data-dismiss='modal']")).click();
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("fatih", Keys.TAB, "fatih.@gmail.com", Keys.TAB, Keys.ENTER);
        //driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("fatih.@gmail.com");


        driver.findElement(By.xpath("(//*[@name='title'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='form-control'])[3]")).sendKeys("123fatih",
                Keys.TAB, "05", Keys.TAB, "June",
                Keys.TAB, "1995", Keys.TAB,
                Keys.SPACE, Keys.TAB, Keys.TAB, "Fatih",
                Keys.TAB, "KÜPELİ", Keys.TAB, "company",
                Keys.TAB, "ANKARA", Keys.TAB, "OSMANİYE",
                Keys.TAB, "CANADA", Keys.TAB, "ABC", Keys.TAB, "DEF", Keys.TAB, "123",
                Keys.TAB, "5449998574", Keys.TAB, Keys.ENTER);

        //driver.switchTo().alert().accept();
        //  }

        // @Test
        //  public void test10() throws InterruptedException {

        //10. 'HESAP OLUŞTURULDU!'nu doğrulayın! ve 'Devam Et' düğmesini tıklayın
        WebElement account = driver.findElement(By.xpath("//*[.='Account Created!']"));
               }
          */


    @Test
    public   void test11 () {

        //    11. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
//

        WebElement userNameControl = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        System.out.println("Kullanıcı adı oalarak oturum acılmıştır :" + userNameControl.isDisplayed());

    }
    @Test
    public  void test12 () throws InterruptedException {

        // 12.'Sepet' düğmesine tıklayın


        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();
        Thread.sleep(3000);


        //   driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

    }
    @Test
    public   void test13 () throws InterruptedException {

//            //    13. 'Ödeme İşlemine Devam Et' düğmesini tıklayın

        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //driver.findElement(By.xpath("(//*[@href='/login'])[2]")).click();
        // test07();
//   }

        //    14. Adres Ayrıntılarını Doğrulayın
        WebElement AdressCheck = driver.findElement(By.xpath("(//*[@class='address_title'])[1]"));
        System.out.println("Adres Kontrol  :" + AdressCheck.isDisplayed());

        WebElement AdressCheck1=driver.findElement(By.xpath("(//*[@class='address_title'])[1]"));
        System.out.println("Adres Kontrol1  :" + AdressCheck1.isDisplayed());
        Thread.sleep(3000);



        //Siparişinizi İnceleyin
        WebElement SiparisCheck = driver.findElement(By.xpath("//*[.='Review Your Order']"));
        System.out.println("Sipariş Kontrol  :" + SiparisCheck.isDisplayed());
    }

    @Test
    public   void test15() throws InterruptedException {
//    15. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.navigate().refresh();
//                driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).sendKeys("Ürünün Paketlenmesinde problemler var.");
//                Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        Thread.sleep(5000);

    }
    @Test
    public  void test16() {

//    16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='submit']")).
                sendKeys("Garanti Bonus Card",
                        Keys.TAB, "4450 0000 4444 9999",
                        Keys.TAB, "354",
                        Keys.TAB, "10",
                        Keys.TAB, "2050");
    }


    @Test
    public   void test17() {
        //    17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
    }

    @Test
    public   void test18() {
//    18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        WebElement SiparisMsj = driver.findElement(By.xpath("//*[@style='font-size: 20px; font-family: garamond;']"));
        System.out.println("SiparisMsj = " + SiparisMsj.isDisplayed());

    }
    /*
             @Test
             public   void test19() {
                 //    19. 'Hesabı Sil' düğmesini tıklayın
                     driver.navigate().refresh();
                 driver.findElement(By.xpath("(//*[@style='color:brown;'])[2]")).click();
             }
             @Test
             public   void test20() {

                 //    20. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
                 WebElement HesapSilindiMsj = driver.findElement(By.xpath("(//*[.='Account Deleted!'])[2]"));
                 System.out.println("HesapSilindiMsj = " + HesapSilindiMsj.isDisplayed());

                //Devam et dügmesine tıklayınız.
                driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
           }
    */
    @AfterClass
    public  static void teardown () {
        //driver.close();

    }


}
