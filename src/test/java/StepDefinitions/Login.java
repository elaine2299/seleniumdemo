package StepDefinitions;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import resources.Base;

import java.io.IOException;

public class Login extends Base {
    WebDriver driver;
    HomePage homepage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("View the Webpage")
    public void view_the_webpage() throws IOException, InterruptedException {
        driver = Initialize_Driver();
        log.info("Launch Browser");
    }

    @Given("Navigate to Login page")
    public void navigate_to_login_page() {
        driver.get(prop.getProperty("URL"));
        log.info("Access URL");
        homepage = new HomePage(driver);
        homepage.getMyAccountDropDown().click();
        homepage.getLogin().click();
    }

    @When("The users enters username as {string} and password as {string}")
    public void the_users_enters_username_as_and_password_as(String emailAddress, String password) {
        loginPage = new LoginPage(driver);
        loginPage.getEmailAddress().sendKeys(emailAddress);
        loginPage.getPassword().sendKeys(password);

    }

    @When("Clicks on the Submit button")
    public void clicks_on_the_submit_button() {
        loginPage.getSubmitButton().click();

    }

    @Then("Verify the login was {string}")
    public void verify_the_login_was(String expectedResult) {
        accountPage = new AccountPage(driver);

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

    @After
    public void tearDown() {
        driver.quit();

    }

}
