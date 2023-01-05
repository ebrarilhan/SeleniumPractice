package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_Ali {
    WebDriver driver;

    @Before
    public void setUp() {
        //  1. Launch browser.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
    }

    @Test
    public void test01() {
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //  3. Verify that home page is visible successfully  / Anasayfanın görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://automationexercise.com";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("passed");
        }else System.out.println("failed");

        //  4. Click on 'Signup / Login' button  / üye olma butonuna tıkla
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //  5. Verify 'New User Signup!' is visible  / yeni kullanıcı görünür olduğunu doğrula
        WebElement yeniKullanici = driver.findElement(By.xpath("(//h2)[3]"));
        if(yeniKullanici.isDisplayed()){
            System.out.println("yeni kullanıcı passed");
        }else System.out.println("yeni kullanıcı failed");

        //  6. Enter name and email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("aloska");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("battal.aloska@gmail.com");

        //  7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement hesapBilgisi = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(hesapBilgisi.isDisplayed());

        //  9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).sendKeys("bay");  // title "Mr"
        driver.findElement(By.xpath("//*[@id='id_gender2']"));  // title "Mrs"
        driver.findElement(By.id("name"));  // name
        driver.findElement(By.id("email"));  // email
        driver.findElement(By.id("password")).sendKeys("223957");  // password
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("25");  // gun
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("05");  // ay
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1980");  // yıl

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@for='newsletter']")).click();

        // 11. Select checkbox 'Receive special offers from our partners!
        driver.findElement(By.xpath("//*[@for='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Ali");
        driver.findElement(By.id("last_name")).sendKeys("Qayik");
        driver.findElement(By.id("company")).sendKeys("celebi");
        driver.findElement(By.id("address1")).sendKeys("sancaktepe");
        driver.findElement(By.id("address2")).sendKeys("cekmekoy");
        driver.findElement(By.id("country")).sendKeys("Canada");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Bavyera");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Amsterdam");
        driver.findElement(By.id("zipcode")).sendKeys("34672");
        driver.findElement(By.id("mobile_number")).sendKeys("535 430 1277");

        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement olusturlmusHesap = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(olusturlmusHesap.isDisplayed());

        //  15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        // 16. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@class='fa fa-user']"));

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click
        driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
