package restAssuredTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginPage() {
        driver.get("https://example.com/login");
        // your test steps
        System.out.println("Login page test executed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}