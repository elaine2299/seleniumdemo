package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import  org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Elaine\\OneDrive\\Documents\\STUDY MATERIALS\\SELENIUM\\USING JAVA\\CUCUMBER\\Live_Proj_demo\\src\\test\\java\\features",
        glue = "StepDefinitions")
public class Run{
}
