package Tests;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;
import java.util.concurrent.TimeUnit;

import java.io.IOException;

public class Login extends Base {

    //WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        // Initialize the driver before the test
        driver = Initialize_Driver();
        log.info("Launch Browser");
    }

    @Test(priority = 1)
    public void accessURL() throws IOException, InterruptedException {
        // Use the initialized driver
        driver.get(prop.getProperty("URL"));
        log.info("Access URL");
    }

    @Test(priority = 2, dependsOnMethods = "accessURL")
    public void homePage(){
        HomePage  homepage = new HomePage(driver);
        homepage.getMyAccountDropDown().click();
        homepage.getLogin().click();
    }

    @Test(priority = 3, dependsOnMethods = "homePage", dataProvider = "loginCredentials")
    public void login(String emailAddress, String password, String expectedResult ) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailAddress().sendKeys(emailAddress);
        loginPage.getPassword().sendKeys(password);

        loginPage.getSubmitButton().click();
    }

    @Test(priority = 4 ,dependsOnMethods = "login", dataProvider = "loginCredentials")
    public void successfulLogin(String emailAddress, String password, String expectedResult) {
        AccountPage accountPage = new AccountPage(driver);

        // Verify that the "Edit Account Details" link is displayed
        String actualresult = null;
        try{
            if(accountPage.getEditAccDetailsLink().isDisplayed()) {
                actualresult = "Successful";
            }
        } catch(Exception e){
            actualresult = "Failure";
        }
        Assert.assertEquals(actualresult, expectedResult);
    }

    @Test(priority = 5, dependsOnMethods = "successfulLogin" )
    public void logout(){
        AccountPage  accountPage = new AccountPage(driver);
        accountPage.getMyAccountDropDown().click();
        accountPage.getLogoutLink().click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    // Data driven testing and parameterization
    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials(){
        return new Object[][]{
                {"selenium_java_123@gmail.com", "Elaine12345*", "Successful"}/*,
                {"selenium_java@gmail.com", "Elaine*", "Failure"}*/
        };
    }
}
