package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"steps"})

// format = {"pretty", "html:target/cucumber"}
//         tags = {"@web"},
public class ChromeTestRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite
    public static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.qatarairways.com/en-us/homepage.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterSuite
    public static void killSession(){
        driver.quit();
    }

}
