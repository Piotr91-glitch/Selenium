package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddaddressPage {

    private WebDriver driver;
    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name="address")
    private WebElement addressinput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "company")
    private WebElement companyImput;

    @FindBy(name = "vat_number")
    private WebElement vatNrImput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;

    @FindBy(name = "address2")
    private WebElement addresComplanet;

    @FindBy(name = "city")
    private WebElement cityImput;
    @FindBy(name="postcode")
    private WebElement codeInput;

    public AddaddressPage(WebDriver driver) {
        this.driver = driver;


        PageFactory.initElements(this.driver, this);
    }

    public void addNewAddress(String firstname,String address ,String lastname, String alias,
                              String company,String vat_number,String city, String address2 ,String code) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);

        aliasInput.clear();
        aliasInput.sendKeys(alias);

        companyImput.clear();
        companyImput.sendKeys(company);

        vatNrImput.clear();
        vatNrImput.sendKeys(vat_number);

        cityImput.clear();
        cityImput.sendKeys(city);

        addresComplanet.clear();
        addresComplanet.sendKeys(address2);

        addressInput.clear();
        addressInput.sendKeys(address);
codeInput.clear();
codeInput.sendKeys(code);

    }

}
