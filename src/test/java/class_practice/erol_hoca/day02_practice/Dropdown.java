package class_practice.erol_hoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Dropdown extends TestBase {

    @Test
    public void test01(){

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //dropdown menuyu yazdiralim.
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t-> System.out.println(t.getText()));

        // dropdown ikinci yontem ile: select objesi olusturmadan
        //dropdown menuden Baby secelim.
        //arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).
                sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);


    }
}
