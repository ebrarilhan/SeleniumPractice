import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class random extends TestBase {


    @Test
    public void test() {
        //1Yeni bir class olusturalim: MouseActions1
        //2https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        WebElement kutucuk = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutucuk).perform();

        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actual = driver.switchTo().alert().getText();
        String expected = "You selected a context menu";
        Assert.assertEquals(expected,actual);

        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        String h1 = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Elemental Selenium",h1);


    }
}
