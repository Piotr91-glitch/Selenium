package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Katalon {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void KatalonTest() {
        WebElement FirstName = driver.findElement(By.name("firstName"));
        FirstName.clear();
        FirstName.sendKeys("karol");
        WebElement LastName = driver.findElement(By.name("lastName"));
        LastName.clear();
        LastName.sendKeys("Kowalski");
        WebElement Gender = driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div/div/label[1]/input"));
        Gender.click();

        WebElement DateOfBirth = driver.findElement(By.name("dob"));
        DateOfBirth.sendKeys(" 05/22/2010");
        WebElement Address = driver.findElement(By.name("address"));
        Address.sendKeys("Prosta 51");
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("karol.kowalski@malinator.com");
        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("Pass123");
        WebElement Company = driver.findElement(By.name("company"));
        Company.sendKeys("Coders Lab");
        WebElement Comment = driver.findElement(By.name("comment"));
        Comment.sendKeys("To jest moj pierwszy automat testowy");
        WebElement Submit = driver.findElement(By.id("submit"));
        Submit.click();

    }

    @After
    public void TearDown() {
        driver.quit();
    }


}


