package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.xpath;

public class FaceBookTest{

    private WebDriver wd;
    private String url;
    private String  LogUser;
    private String  PassUser;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");


        wd= new ChromeDriver();
        url="https://zalukaj.cc/";
        LogUser="Pjetrek";
        PassUser="krol";


    }@Test
    public void LoginTestZalukaj(){
        Dimension wymiar = new Dimension(600,800);
        wd.manage().window().setSize(wymiar);
        wd.get(url);
        WebElement Loginname = wd.findElement(By.name("login"));
        Loginname.clear();
        Loginname.sendKeys(LogUser);
        WebElement Loginpass= wd.findElement(By.name("password"));
        Loginpass.clear();
        Loginpass.sendKeys(PassUser);
        WebElement Zaloguj= wd.findElement(By.xpath("//*[@id=\"right\"]/div[1]/form/table/tbody/tr[2]/td[2]/input"));
        Zaloguj.click();

    }


    @After
    public void teardown(){
    // wd.quit();
    }

        }
