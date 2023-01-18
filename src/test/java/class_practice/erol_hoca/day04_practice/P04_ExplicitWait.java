package class_practice.erol_hoca.day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P04_ExplicitWait extends TestBase {

     /*
                                    - Explicit Wait -
        Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
    “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
    Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
    Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
        Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
    sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
Syntax:
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));
     */

    //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
    //Start button'nuna basalım
    //Hello World! yazısının çıktığını doğrulayalım



    //visibility methodu ile
    @Test
    public void visibleTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorldText = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        //Start buttonuna bastıktan sonra Hello World! yazısı görünene kadar bekledik
        assert helloWorldText.isDisplayed();
    }


    //invisibility methodu ile
    @Test
    public void invisibleTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loadingText = driver.findElement(By.xpath("//div[@id='loading']"));
        wait.until(ExpectedConditions.invisibilityOf(loadingText));
        //Start buttonuna bastıktan sonra Loading webelementi kaybolana kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
    }
}
