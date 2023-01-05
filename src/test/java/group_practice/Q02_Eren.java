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

public class Q02_Eren {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
    }

    @Test
    public void urlTest(){
        //3. Verify that home page is visible successfully
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        Assert.assertEquals("Home page is not visible",expectedURL,actualURL);
    }
    @Test
    public void loginUserWithCorrectInfo(){

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class=\"fa fa-lock\"]")).click();
        //5. Verify 'Login to your account' is visible
        String actualLoginTextVerification = driver.findElement(By.xpath("//*[text()=\"Login to your account\"]")).getText();
        String expectedLoginTextVerification = "Login to your account";
        Assert.assertEquals("Login to your account is not visible", expectedLoginTextVerification, actualLoginTextVerification);
        //6. Enter correct email address and password
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
        emailBox.sendKeys("cokdogrubiremail@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
        passwordBox.sendKeys("cokdogrubirsifre123");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).submit();
        //8. Verify that 'Logged in as username' is visible
        WebElement actualLoginVerification = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(actualLoginVerification.isDisplayed());
        //9. Click 'Delete Account' button
        WebElement deleteButton = driver.findElement(By.xpath("//*[@href=\"/delete_account\"]"));
        deleteButton.click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement actualDeletingMessage = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(actualDeletingMessage.isDisplayed());

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
