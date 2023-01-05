package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04_Barbaros {

    public static void main(String[] args) {
//        1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        String homePageUrl = driver.getCurrentUrl();
        String ExpectedHomePageUrl = "https://automationexercise.com/";
        Assert.assertEquals("Home Page is not Correct" , ExpectedHomePageUrl,homePageUrl);


//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();

//        5. Verify 'Login to your account' is visible
        WebElement loginAccount = driver.findElement(By.xpath("//*[text()=\"Login to your account\"]"));
        Assert.assertTrue(loginAccount.isDisplayed());

//        6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@name=\"email\"])[1]")).sendKeys("ayse@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("1234");

//        7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();

//        8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//*[@class=\"fa fa-user\"]"));
        Assert.assertTrue(logged.isDisplayed());

//        9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();

//        10. Verify that user is navigated to login page
        WebElement loginPage = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(loginPage.isDisplayed());





    }


}
