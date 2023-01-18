package class_practice.erol_hoca.day04_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03_Faker extends TestBase {

    /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */

    //"https://demoqa.com/automation-practice-form"  Adresine gidin
    // Formu doldurunuz
    // Sayfayi kapatin


    @Test
    public void test() throws InterruptedException {

        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");

        // Formu doldurunuz
        Faker faker = new Faker();
        WebElement firsName = driver.findElement(By.id("firstName"));
        firsName.sendKeys(faker.name().firstName(), //isim
                Keys.TAB,faker.name().lastName(), //soyisim
                Keys.TAB,faker.internet().emailAddress(), //email adres
                Keys.TAB,Keys.ARROW_RIGHT, //cinsiyet
                Keys.TAB,faker.phoneNumber().cellPhone(), //telefon
                Keys.TAB,"20 Jul 1980",Keys.ENTER,
                Keys.TAB,faker.shakespeare().romeoAndJulietQuote(), //konu
                Keys.TAB,Keys.SPACE); //hobi

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
//        String dosyaYolu = "C:\Users\vysl\OneDrive\Masaüstü\logo.jpeg";
        //direkt yukaridaki sekilde de yapabiliriz.

        //uzun yol:
        String anaYol = System.getProperty("user.home"); //C:\\Users\\vysl\\
        String ortakYol = "\\OneDrive\\Masaüstü\\logo.jpeg";
        String dosyaYolu = anaYol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        WebElement adress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        adress.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR");
        Thread.sleep(2000);

        // Sayfayi kapatin

    }
}
