package ZadaniaWarsztaty;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarZadanie1 {
    private WebDriver driver;

    @Given("SetUp")
    public void SetUp01() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

    }

    @When("user must login")
    public void login() {
        WebElement signin = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signin.click();

        WebElement login = driver.findElement(By.name("email"));
        login.clear();
        login.sendKeys("staraproca69@gamon.com");

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("qwerty");
        pass.submit();
        WebElement addressesWindow = driver.findElement(By.xpath("//*[@id='addresses-link']|//*[@id='address-link']"));
        addressesWindow.click();
        WebElement creatNewAddress = driver.findElement(By.cssSelector("[data-link-action='add-address']"));
        creatNewAddress.click();

    }

    @And("the logged in user adds a new address(.*),(.*),(.*),(.*),(.*),(.*)")
    public void Addaddress(String alias, String address, String city, String zip, String country, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement zipInput = driver.findElement(By.name("postcode"));
        zipInput.clear();
        zipInput.sendKeys(zip);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);


        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.clear();
        addressInput.sendKeys(address);

        Select roledropdown = new Select(driver.findElement(By.name("id_country")));
        roledropdown.selectByVisibleText(country);


        WebElement save = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        save.click();

    }

//    @Then("check if the data is correct")
//    public void checkifthedataiscorrect() {
//        WebElement lastAddress = driver.findElement(By.xpath("(//address)[last()]"));
//        String addressText = lastAddress.getText();
//
//   }

    @Then("^check if the data is correct (.*),(.*),(.*),(.*),(.*),(.*)$")
    public void checkIfTheDataIsCorrectAliasAddressCityZipCountryPhone(String alias, String address, String city, String zip, String country, String phone) {
        WebElement lastAddress = driver.findElement(By.xpath("(//article)[last()]"));
        String addressText = lastAddress.getText();
        Assert.assertTrue(addressText.contains(alias));
        Assert.assertTrue(addressText.contains(address));
        Assert.assertTrue(addressText.contains(city));
        Assert.assertTrue(addressText.contains(zip));
        Assert.assertTrue(addressText.contains(country));
        Assert.assertTrue(addressText.contains(phone));
    }

    @And("will delete the above address")
    public void deleteaddress() {
        List<WebElement> addresses = driver.findElements(By.tagName("article"));
        WebElement lastAddress = addresses.get(addresses.size() - 1);
        WebElement deleteFromLastAddress = lastAddress.findElement(By.cssSelector("[data-link-action='delete-address']"));
        deleteFromLastAddress.click();
    }

    @And("will check if the address has been removed")
    public void checkAddress() {
       WebElement checkinformation = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
       String informationText = checkinformation.getText();
       Assert.assertTrue(informationText.contains("Address successfully deleted!"));


    }

}