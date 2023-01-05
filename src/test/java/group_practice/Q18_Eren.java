package group_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utilities.TestBase;

public class Q18_Eren extends TestBase {

    @Test
    public void viewCathegory(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that categories are visible on left side bar
        WebElement categoryIsDisplayed = driver.findElement(By.xpath("//*[text()='Category']"));
        Assert.assertTrue(categoryIsDisplayed.isDisplayed());

        //4. Click on 'Women' category
        driver.findElement(By.xpath("(//*[@class=\"fa fa-plus\"])[1]")).click();

        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//*[text()='Tops '] ")).click();

        //reklamlardan kurutlmak icin islemleri tekrarladik.
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@class=\"fa fa-plus\"])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Tops '] ")).click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        String actualUrl = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/category_products/2";
        Assert.assertEquals(expectedURL,actualUrl);

        String actualProductTitle = driver.findElement(By.xpath("//*[@class=\"title text-center\"] ")).getText();
        String expectedProductTitle = "WOMEN - TOPS PRODUCTS";
        Assert.assertEquals(expectedProductTitle,actualProductTitle);

        //7. On left side bar, click on any sub-category link of 'Men' category
        WebElement manCategory = driver.findElement(By.xpath("(//*[@class=\"fa fa-plus\"])[2]"));
        manCategory.click();
        driver.findElement(By.xpath("//*[text()=\"Jeans \"] ")).click();

        //8. Verify that user is navigated to that category page
        String menCategoryTitle = driver.findElement(By.xpath("//*[@class=\"title text-center\"] ")).getText();
        String expectedMenCategoryTitle = "MEN - JEANS PRODUCTS";
        Assert.assertEquals(expectedMenCategoryTitle,menCategoryTitle);

    }


}
