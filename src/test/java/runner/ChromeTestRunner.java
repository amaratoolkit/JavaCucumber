package runner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = {"@web"},
        glue={"steps"},
        format = {"pretty", "html:target/cucumber"})

public class ChromeTestRunner {
    public static WebDriver driver;

    @BeforeClass
    public static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.qatarairways.com/en-us/homepage.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void killSession(){
        driver.quit();
    }

}
