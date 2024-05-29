package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Account")
    WebElement editAccDetailsLink;
    public WebElement getEditAccDetailsLink (){
        return editAccDetailsLink;
    }

    @FindBy(xpath="//a[@title='My Account']")
    WebElement getMyAccountDropDown;
    public WebElement getMyAccountDropDown(){
        return getMyAccountDropDown;
    }

    @FindBy(linkText = "Logout")
    WebElement logoutLink;
    public  WebElement getLogoutLink(){
        return logoutLink;
    }
}
