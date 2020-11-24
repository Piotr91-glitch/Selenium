package Pages;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GmailAccount {

    private WebDriver driver;

    @Given("Setup2")
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://www.google.com/intl/pl/gmail/about/");


    }@Then("nowe konto")
    public void webside(){
        WebElement utworzKonto = driver.findElement(By.className("h-c-button h-c-header__cta-li-link h-c-header__cta-li-link--primary"));
        utworzKonto.click();

    }
    @And("use button Utwórz konto")
    public  void register(){
        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.addNewEmail("Piotr","Pobożniak","pobozniak91-QA-tester"
                ,"QA-Tester"    ,"QA-Tester");
        WebElement dalej=driver.findElement(By.className("VfPpkd-RLmnJb"));
        dalej.click();

    }


}
