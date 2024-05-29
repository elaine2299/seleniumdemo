package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class HomePage extends Base {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@title='My Account']")
    WebElement getMyAccountDropDown;
    public WebElement getMyAccountDropDown(){
        return getMyAccountDropDown;
    }

    @FindBy(linkText = "Login")
    WebElement getLogin;
    public  WebElement getLogin(){
        return getLogin;
    }
    


}
