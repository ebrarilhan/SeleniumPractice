package group_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q17_Ebrar extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Add products to cart
    //5. Click 'Cart' button
    //6. Verify that cart page is displayed
    //7. Click 'X' button corresponding to particular product
    //8. Verify that product is removed from the cart

    @Test
    public void test01() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertNotEquals("http://automationexercise.com",driver.getCurrentUrl());

        //4. Add products to cart
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();//urun ekleme
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();//devama basma

        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();//sepete gitme

        //6. Verify that cart page is displayed
        driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed();

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();//sepetteki urunu kaldirdik
        Thread.sleep(2000);//bu adim gorunurluk acisindan onemli

        //8. Verify that product is removed from the cart
        WebElement text = driver.findElement(By.xpath("//*[@style='font-size: 18px;']"));
        String expected = "Cart is empty! Click here to buy products.";
        String actual = text.getText();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);


    }

}
