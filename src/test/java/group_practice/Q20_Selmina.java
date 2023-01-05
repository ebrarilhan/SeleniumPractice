package group_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import utilities.TestBase;

public class Q20_Selmina extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //    1. Launch browser
//    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //Thread.sleep(2000);
//    3. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@href='/products']")).click();

//    4. Verify user is navigated to ALL PRODUCTS page successfully
        String actual = driver.findElement(By.xpath("//*[@class='title text-center']")).getText();
        String expected = "ALL PRODUCTS";
        Assert.assertEquals(expected,actual);
        //Thread.sleep(2000);

//    5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("Blue",Keys.TAB, Keys.ENTER);


//    6. Verify 'SEARCHED PRODUCTS' is visible
        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();
        // Thread.sleep(2000);

//    7. Verify all the products related to search are visible
        List<WebElement> urunResimlerininVarligi = driver.findElements(By.xpath("//*[@alt='ecommerce website products']"));

        for (WebElement element : urunResimlerininVarligi){
            element.isDisplayed();
        }

//    8. Add those products to cart
        List<WebElement> tumUrunler = driver.findElements(By.xpath("//*[@class='productinfo text-center']//*[@class='btn btn-default add-to-cart']"));
        WebElement kabulTusu = driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']"));

        for (int i = 0; i <tumUrunler.size() ; i++) {
            tumUrunler.get(i).click();
            kabulTusu.click();
        }


//    9. Click 'Cart' button and verify that products are visible in cart
//    10. Click 'Signup / Login' button and submit login details
//    11. Again, go to Cart page
//    12. Verify that those products are visible in cart after login as well

    }
}
