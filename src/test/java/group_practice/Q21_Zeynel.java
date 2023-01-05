package group_practice;

import utilities.TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q21_Zeynel extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        ////1. Launch browser
        //    //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("https://automationexercise.com");

        //    //3. Click on 'Products' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@href=\"/products\"]")).click();
        driver.navigate().refresh();//reklam cikiyor
        driver.findElement(By.xpath("//*[@href=\"/products\"]")).click();

        //    //4. Verify user is navigated to ALL PRODUCTS page successfully
        String tumUrunlerGor=driver.getCurrentUrl();
        Assert.assertTrue(tumUrunlerGor.contains("https://automationexercise.com/products"));

        //    //5. Click on 'View Product' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@href=\"/product_details/4\"]")).click();

        //    //6. Verify 'Write Your Review' is visible
        WebElement yaziyiGor= driver.findElement(By.xpath("//*[@href=\"#reviews\"]"));
        System.out.println("yaziyiGor.isDisplayed() = " + yaziyiGor.isDisplayed());

        //    //7. Enter name, email and review
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("azram");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("azram@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"review\"]")).sendKeys("toliconam");

        //    //8. Click 'Submit' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();

        //9. Verify success message 'Thank you for your review.'
        //Bu kismi yapamadim.Yapan olursa ogrenmek isterim
    }
}
