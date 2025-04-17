package restAssuredTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
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