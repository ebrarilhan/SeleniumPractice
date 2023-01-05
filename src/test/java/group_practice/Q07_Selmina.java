package group_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q07_Selmina extends TestBase{

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Test Cases' button
    //5. Verify user is navigated to test cases page successfully

    @Test
    public void test() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        //driver.navigate().to("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(expectedTitle,actualTitle);

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//*[@class='fa fa-list'])[1]")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();//anasayfaya dondu
        driver.findElement(By.xpath("(//*[@class='fa fa-list'])[1]")).click();//tekrar test case gittik

        //5. Verify user is navigated to test cases page successfully
        WebElement text = driver.findElement(By.xpath("//*[@class='title text-center']"));
        text.isDisplayed();
        System.out.println("text = " + text.getText());

    }

}
