package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class Test2 extends Base {

    @Test
    public void sampleTest2() throws IOException, InterruptedException {
        System.out.println("This is sampleTest2");
        WebDriver driver = Initialize_Driver();
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(2000);
        driver.quit();
        log.info("Test2 executed");

    }
}
