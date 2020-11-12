package przyklad1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

public class BingSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();


        driver.manage().window().maximize();

        driver.get("https://www.bing.com/");
    }
    @Test
    public void testBingSearch() {

        WebElement element = driver.findElement(By.name("q"));

        element.clear();


        element.sendKeys("Mistrzostwa świata w piłce nożnej");


        element.submit();
    }
    @After
    public void tearDown() throws Exception {

        driver.quit();
    }
}