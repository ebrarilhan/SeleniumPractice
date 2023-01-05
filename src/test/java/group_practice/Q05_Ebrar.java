package group_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class Q05_Ebrar {


    WebDriver driver;

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
        System.out.println("Before");
    }


    @Test
    public void test01(){
        //3. Verify that home page is visible successfull

//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "http://automationexercise.com";
//        Assert.assertNotEquals(expectedUrl,actualUrl);

//        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
//                System.out.println("Input Tag Sayisi = " + inputTags.size());

        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
//        System.out.println("Link Sayisi = " + linklerList.size());

        // linklerin kendisini yazdirma:
        for (WebElement w : linklerList){
            w.isDisplayed();
        }


        System.out.println("Test01 Passed");
    }

    @Test
    public void test02(){
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        System.out.println("Test02");
    }

    @Test
    public void test03(){
        test02();
        //5. Verify 'New User Signup!' is visible
        String actualText = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        String expectedText = "New User Signup!";
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Test03");
    }

    @Test
    public void test04(){
        test02();
        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        name.sendKeys("Ebrar", Keys.TAB,"salihaebrarilhan@gmail.com",Keys.TAB,Keys.SPACE);
        System.out.println("Test04");
    }

    @Test
    public void test05(){
        test04();
        //8. Verify error 'Email Address already exist!' is visible
        driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed();
        System.out.println("Test05");
    }

    @After
    public void tearDown(){
        driver.quit();
        System.out.println("After");
    }



}
