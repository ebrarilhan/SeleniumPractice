package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.time.Duration;

public class Q12_Muhammed {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test12() throws InterruptedException, AWTException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(2000);
        //Reklami manuel olarak kapattik. Gelistirilmeli

        //5. Hover over first product and click 'Add to cart'
        WebElement firstEl = driver.findElement(By.xpath("(//*[@class='product-overlay'])[1]"));

        // hover icin Action clasindan yeni bir obje olusturuyoruz
        Actions action = new Actions(driver);
        action.moveToElement(firstEl).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();
        Thread.sleep(2000);

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[.='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        WebElement secondEl = driver.findElement(By.xpath("(//*[@class='product-overlay'])[2]"));
        action.moveToElement(secondEl).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@data-product-id='2'])")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[.='View Cart'])[1]")).click();

        //9. Verify both products are added to Cart // gelistirilmesi lazim
        System.out.println(driver.findElement(By.id("product-1")).isDisplayed());
        System.out.println(driver.findElement(By.id("product-2")).isDisplayed());
        //Gelistirilmeli

        //10. Verify their prices, quantity and total price
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-1']//td[@class='cart_price']")).isDisplayed());//product 1, price
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-2']//td[@class='cart_price']")).isDisplayed());//product 2, price
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-1']//button[.='1']")).isDisplayed());//product 1, quantity
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-2']//button[.='1']")).isDisplayed());//product 2, quantity
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='cart_total']//p[.='Rs. 500']")).isDisplayed());//product 1, total price
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='cart_total']//p[.='Rs. 400']")).isDisplayed());//product 2, total price
    }


}
