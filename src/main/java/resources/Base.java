package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public  Properties prop;
    public static Logger log = LogManager.getLogger();

    public WebDriver Initialize_Driver() throws IOException, InterruptedException {

        prop = new Properties();
        String prop_path = "C:\\Users\\Elaine\\OneDrive\\Documents\\STUDY MATERIALS\\SELENIUM\\USING JAVA\\CUCUMBER\\Live_Proj_demo\\src\\main\\java\\resources\\data.properties";
        FileInputStream fis = new FileInputStream(prop_path);
        prop.load(fis);

        //String BrowserName = prop.getProperty("Browser");
        String BrowserName = "Chrome";

        if(BrowserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (BrowserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (BrowserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }
        driver.manage().window().maximize();
        Thread.sleep(7000);

        return driver;

    }

    public String takeScreenshots(String testName, WebDriver driver) throws IOException {
        // Code to take screenshot on failure of any test
        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = "C:\\Users\\Elaine\\OneDrive\\Documents\\STUDY MATERIALS\\SELENIUM\\USING JAVA\\CUCUMBER\\Live_Proj_demo\\src\\main\\java\\screenshots\\"+ testName +".png";
        FileUtils.copyFile(SourceFile,new File(destinationFilePath));
        return destinationFilePath;

    }

    public WebDriver getDriver() {
        return driver;
    }
}
