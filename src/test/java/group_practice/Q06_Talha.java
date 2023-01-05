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

public class Q06_Talha {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test06() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,actualUrl);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class=\"fa fa-envelope\"]")).click();

        //5. Verify 'GET IN TOUCH' is visible
        driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed();

        //6. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys("Talha", Keys.TAB,"talha@gmail.com",Keys.TAB,"Complaint",Keys.TAB,
                "I want to complain about your product.");

        //7. Upload file
        WebElement upload_file = driver.findElement(By.name("upload_file"));
        upload_file.sendKeys("C:/Users/snmt/Desktop/abc.txt");

        //8. Click 'Submit' button
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();

        //9. Click OK button
        Thread.sleep(2000);
        driver.switchTo().alert().accept();//cikan uyari pencerelerine gecis yapip kabul(ok) tusuna basma kodu.

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement basariMesaji= driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        Assert.assertTrue(basariMesaji.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class=\"fa fa-home\"]")).click();

        //  driver.switchTo().alert().dismiss();//cikan uyari pencerelerine gecis yapip red(cancel/decline) tusuna basma kodu.
        //driver.navigate().refresh();//cikan reklam pencerelerini kapatma kodu.
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
