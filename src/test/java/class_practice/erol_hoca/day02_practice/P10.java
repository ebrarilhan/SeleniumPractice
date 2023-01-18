package class_practice.erol_hoca.day02_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P10 extends TestBase {

    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

    @Test
    public void test01() throws InterruptedException {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement cerezler = driver.findElement(By.className("faktor-iframe-wrapper"));
        driver.switchTo().frame(cerezler);
        driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        driver.navigate().refresh();

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe Sayisi = "+iframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(3000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.navigate().refresh();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@name='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();


    }

}
