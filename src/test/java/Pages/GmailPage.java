package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {

private WebDriver driver;

@FindBy(id="firstName")
    WebElement firstNameInput;

@FindBy(name="lastName")
    WebElement lastNameInput;

@FindBy(className = "whsOnd zHQkBf")
    WebElement mailInput;
@FindBy(name="passwd")
    WebElement passInput;

@FindBy(xpath = "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")
    WebElement confirmInput;





public GmailPage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(this.driver,this);
}
public void addNewEmail(String firstName,String lastName,String mail,
                        String password,String confirm){
firstNameInput.clear();
firstNameInput.sendKeys(firstName);

lastNameInput.clear();
lastNameInput.sendKeys(lastName);

mailInput.clear();
mailInput.sendKeys(mail);

passInput.clear();
passInput.sendKeys(password);

confirmInput.clear();
confirmInput.sendKeys(confirm);



}



}
