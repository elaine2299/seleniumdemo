package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class LoginPage extends Base {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "input-email")
    WebElement getEmailAddress;
    public WebElement getEmailAddress(){
        return getEmailAddress;
    }

    @FindBy(id = "input-password")
    WebElement getPassword;
    public WebElement getPassword(){
        return getPassword;
    }

    @FindBy(xpath = "//input[@value='Login']")
    WebElement getSubmitButton;
    public WebElement getSubmitButton(){
        return getSubmitButton;
    }



}
