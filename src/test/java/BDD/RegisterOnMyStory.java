package BDD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterOnMyStory {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");


    }

    @Test
    public void MyStory() {
        WebElement SingIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        SingIn.click();

        WebElement createaccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        createaccount.click();

        WebElement socialTitle = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/span"));


        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.clear();
        firstname.sendKeys("Karol");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.clear();
        lastname.sendKeys("Krawczyk");

        WebElement Email = driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("dzikiKrawczyk91@poczta.com");

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("karolKrawczyk");

        WebElement buttonShow = driver.findElement(By.className("btn"));
        buttonShow.click();

        WebElement birthday = driver.findElement(By.name("birthday"));
        birthday.clear();
        birthday.sendKeys("16/05/1991");

        WebElement save = driver.findElement(By.className("btn btn-primary form-control-submit float-xs-right"));
        save.click();

    }

    @After
    public void closeBrownesr() {
        driver.quit();
    }


}
