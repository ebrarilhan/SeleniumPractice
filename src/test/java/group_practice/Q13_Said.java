package group_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q13_Said extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'View Product' for any product on home page
    //5. Verify product detail is opened
    //6. Increase quantity to 4
    //7. Click 'Add to cart' button
    //8. Click 'View Cart' button
    //9. Verify that product is displayed in cart page with exact quantity

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actual = driver.getCurrentUrl();
        String expected = "https://automationexercise.com";
        Assert.assertNotEquals("yanlis oldu",expected,actual);

        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//*[@href='/products']")).click();

        //reklamlar icin sayfayi yenileyip islemleri tekrarladik
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/products']")).click();

        //5. Verify product detail is opened
        String actual2 = driver.findElement(By.xpath("//*[@class='title text-center']")).getText();
        String expected2 = "ALL PRODUCTS";
        Assert.assertEquals(expected2,actual2);

        //6. Increase quantity to 4
        //7. Click 'Add to cart' button
        //8. Click 'View Cart' button
        //9. Verify that product is displayed in cart page with exact quantity
    }
}
