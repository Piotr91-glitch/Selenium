package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AsserciaTest {


    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }@Test
    public void assTest(){
        driver.get("https://www.google.com/");
        WebElement search=driver.findElement(By.name("q"));
        if(search.isDisplayed()){
            search.sendKeys("skawina");
            search.submit();
        }else{
            Assert.fail();
        }

    }@Test
    public void assert2(){
        driver.get("https://www.google.com/");
        WebElement search=driver.findElement(By.name("q"));
        if (search.isEnabled()){
            search.sendKeys("skawina");
            search.submit();

        }else{
            Assert.fail();
        }

    }
    @After
    public void quit(){
        driver.quit();
    }

}
