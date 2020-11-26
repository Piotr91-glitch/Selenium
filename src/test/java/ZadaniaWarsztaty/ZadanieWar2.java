package ZadaniaWarsztaty;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.eo.Se;
import cucumber.runtime.java.StepDefAnnotation;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ZadanieWar2 {

    private WebDriver driver;


    @Given("setup")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");


    }

    @Then("check rabat for jumper")
    public void checkRabat() {
        WebElement signin = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signin.click();

        WebElement login = driver.findElement(By.name("email"));
        login.clear();
        login.sendKeys("staraproca69@gamon.com");

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("qwerty");
        pass.submit();

        WebElement searchJumper = driver.findElement(By.className("ui-autocomplete-input"));
        searchJumper.clear();
        searchJumper.sendKeys("Hummingbird Printed Sweater");
        searchJumper.submit();

        WebElement choosejumper = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/a/img"));
        choosejumper.click();

    }

    @And("choose medium size,choose five art and add to shopping cart")
    public void sizeAndQuantity() {
        WebElement size = driver.findElement(By.id("group_1"));
        size.sendKeys("L");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement Quantity = driver.findElement(By.name("qty"));
        Quantity.clear();
        Quantity.sendKeys("5");

        WebElement addtocart = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
        addtocart.click();

    }

    @Then("move to options \"checkout\"")
    public void checkout() {
        WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        checkOut.click();
        WebElement proceedCheckOut = driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a"));
        proceedCheckOut.click();

    }

    @And("confirm address")
    public void confirmAddres() {
        WebElement confirmAddress = driver.findElement(By.name("confirm-addresses"));
        confirmAddress.click();


    }

    @Then("Will choose pick up")
    public void pickUp() {
        WebElement prestashop = driver.findElement(By.className("carrier-delay"));
        prestashop.click();
        WebElement buttumcontinue = driver.findElement(By.name("confirmDeliveryOption"));
        buttumcontinue.click();

    }

    @And("Select payment options")
    public void payment() {
        WebElement payment = driver.findElement(By.name("payment-option"));
        payment.click();


    }

    @Then("click on the order with an obligation to pay")
    public void order(){
        WebElement agree=driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agree.click();

    WebElement obligationToPay=driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));
    obligationToPay.click();


    } @And("make screenshot with confirm order and price")

      public void takesSnapShot() throws Exception{
        TakesScreenshot scrshot=((TakesScreenshot)driver);
        File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C:\\Users\\piotr\\OneDrive\\Pulpit\\CodersLabProjekty\\kurs.selenium\\src\\main\\resources\\Screenshots\\test.png");
        FileUtils.copyFile(SrcFile,DestFile);

    }


}
