package przyklad1;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZalukajTestBBD {

    private WebDriver driver;

    @Given("an open browser with https://zalukaj.cc/")

    public void SetUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://zalukaj.cc/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }

    @When("The user must login to zalukaj.cc")

    public void Login() {
        WebElement Login = driver.findElement(By.name("login"));
        Login.clear();
        Login.sendKeys("User");

        WebElement Pass = driver.findElement(By.id("password"));
        Pass.clear();
        Pass.sendKeys("lokomotywa");

        WebElement Zaloguj = driver.findElement(By.className("szukajb"));
        Zaloguj.click();


    }

    @Then("User must write in serching windows title films")
    public void FindFilm() {
        WebElement searching = driver.findElement(By.className("in"));
        searching.clear();
        searching.sendKeys("Pętla");

        WebElement szukaj = driver.findElement(By.id("inputsubmit1"));
        szukaj.click();


    }


    @And("user quit")
    public void userquit() {
        driver.quit();
    }


}


//
//    Given an open browser with https://zalukaj.cc/
//        When The user must login to zalukaj.cc
//        Then User must write in serching windows title films
//        And choose  film
//        And check correct title films
//        And user logout
