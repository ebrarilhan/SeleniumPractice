package class_practice.erol_hoca.day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;



public class P02_Actions extends TestBase {

    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */

    @Test
    public void test() {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        //iframe oldugu icin once ona gecmeliyiz.
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        //once yesili sifirliyoruz
        Actions actions = new Actions(driver);
        WebElement yesil = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        actions.dragAndDropBy(yesil,-175,0);//genellikle slider'lar icin bu method kullanilir.

        //sonra maviyi sifirliyoruz
        WebElement mavi = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        actions.dragAndDropBy(mavi,-80,0);

        //sari yapmak icin
        actions.dragAndDropBy(yesil,301,0).release().build().perform();

        //-Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed(); // bu sekilde de assert edilebilir.
    }
}
