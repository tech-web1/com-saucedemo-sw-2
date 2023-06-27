package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseurl="https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseurl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("/input[@class='submit-button btn_action']")).sendKeys("secret_sauc");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        String expectedText="Products";
        String actualText=driver.findElement(By.xpath("/span[@class='title']")).getText();
        Assert.assertEquals("Product is displayed",expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("/input[@class='submit-button btn_action']")).sendKeys("secret_sauc");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        List<WebElement>productNumber=driver.findElements(By.xpath("/select[class='product_sort_container']"));
        System.out.println("Product Number");
    }


}
