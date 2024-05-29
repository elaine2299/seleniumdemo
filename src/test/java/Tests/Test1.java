package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.Base;

import java.io.IOException;

public class Test1 extends Base {
    public WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        driver = Initialize_Driver();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void sampleTest1() throws IOException, InterruptedException {
        System.out.println("This is sampleTest1");
        System.out.println("Test Updated the code");
        System.out.println("Updated in GH");
        Thread.sleep(2000);
        Assert.assertTrue(false);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
