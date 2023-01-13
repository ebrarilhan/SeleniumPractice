package class_practice.erol_hoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P08 extends TestBase {

    //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
    //    aseertion these message

    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText()); //alert uzerindeki yaziyi konsola yazdirdik.
        driver.switchTo().alert().accept(); //alerti kabul ettik.

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        Thread.sleep(2000);

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechproEducation How are you today"
        String text = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println("text = " + text);

        //    aseertion these message
        Assert.assertNotEquals("Hello TechproEducation How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());

    }


}
