import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class random3 extends TestBase {


    @Test
    public void test(){

        driver.get("https://www.linkedin.com");

        driver.findElement(By.xpath("//*[@action-type='ACCEPT']")).click();

        driver.findElement(By.xpath("//*[@name='session_key']")).sendKeys();
    }

}
