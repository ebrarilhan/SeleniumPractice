package class_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class rnadom2 extends TestBase {

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        //4. Add products to cart

        List<WebElement> tumUrunler = driver.findElements(By.xpath("//*[@class='features_items']//*[@class='productinfo text-center']//*[@class='btn btn-default add-to-cart']"));
        WebElement kabulTusu = driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']"));

        for (int i = 0; i <tumUrunler.size() ; i++) {
            tumUrunler.get(i).click();
            kabulTusu.click();
        }


        //5. Click 'Cart' button
        //6. Verify that cart page is displayed
        //7. Click Proceed To Checkout
        //8. Click 'Register / Login' button
        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
