package Pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStoryAddress {

    private WebDriver driver;

    @Given("setup")
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");


    }

    @Then("user must loginsdadasdasd")
    public void adasdasusermustlogin() {
        WebElement loginName = driver.findElement(By.name("email"));
        loginName.clear();
        loginName.sendKeys("staraproca69@gamon.com");

        WebElement loginPass = driver.findElement(By.name("password"));
        loginPass.clear();
        loginPass.sendKeys("qwerty");
        loginPass.submit();


        //WebElement buttomAddress=driver.findElement(By.className("link-item"));
        //buttomAddress.click();

        // WebElement buttomCreadAddress=driver.findElement(By.id("addresses-link"));
        //buttomCreadAddress.click();
        WebElement addressButtom = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i"));
        addressButtom.click();

        WebElement newAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[5]/a/span"));
        newAddress.click();

        AddaddressPage addaddressPage = new AddaddressPage(driver);
        addaddressPage.addNewAddress("Marcin2", "Kowalczyk2",
                "MarcinKowalczyk2", "chmura@91.pl2", "Tesco2", "2131231232"
                , "szczypior2owa5/6", "korabnick2a", "32-0520");


    }

    @And("the user must savaddree the changes")
    public void save() {
        WebElement buttomsave = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        buttomsave.click();

    }

    @And("close browsier")
    public void leave() {
        driver.quit();
    }

}
