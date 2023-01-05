package class_practice.erol_hoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    public static void main(String[] args) {


            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Navigate to  https://testpages.herokuapp.com/styled/index.html
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            // Click on  Calculate under Micro Apps
            driver.findElement(By.id("calculatetest")).click();

            // Type any number in the first input
            // Type any number in the second input
            // Click on Calculate
            driver.findElement(By.id("number1")).sendKeys("30", Keys.TAB,Keys.TAB,"20",Keys.ENTER);

            // Print the result
            WebElement result = driver.findElement(By.xpath("//*[@id='answer']"));
            System.out.println("result = " + result.getText());

            // close driver
            driver.close();


    }


}
