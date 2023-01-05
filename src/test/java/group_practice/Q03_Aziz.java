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

public class Q03_Aziz {

    WebDriver driver;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void anaSayfaGiris() throws InterruptedException {
        ////2. Navigate to url 'http://automationexercise.com/'
        driver.get("https://automationexercise.com/");

        //2. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,actualUrl);


        //3. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //4. Verify 'Login to your account' is visible
        WebElement actualLoginToYourAccount= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(actualLoginToYourAccount.isDisplayed());

        //5. Enter incorrect email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("aziz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("1234");

        //6. Click 'login' button
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //7. Verify error 'Your email or password is incorrect!' is visible
        WebElement actualYourPassword = driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(actualYourPassword.isDisplayed());

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
