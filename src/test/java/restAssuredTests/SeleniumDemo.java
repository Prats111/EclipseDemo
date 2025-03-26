package restAssuredTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
	
	 
	 private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        // Setup ChromeDriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();

	        // Initialize the ChromeDriver
	        driver = new ChromeDriver();

	        // Maximize the browser window
	        driver.manage().window().maximize();

	        // Navigate to the application URL
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    }

	    @Test
	    public void handleAutoSuggestion() throws InterruptedException {
	        // Locate the input field with autosuggestions
	        WebElement autoCompleteInput = driver.findElement(By.id("autocomplete"));

	        // Enter a partial input to trigger the autosuggestion
	        autoCompleteInput.sendKeys("Ind");

	        // Pause to allow suggestions to load
	        Thread.sleep(2000);

	        // Capture all suggestion elements
	        List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));

	        // Iterate through the suggestions and select "India"
	        for (WebElement suggestion : suggestions) {
	            if (suggestion.getText().equals("India")) {
	                suggestion.click();
	                break;
	            }
	        }

	        // Verify the selected value
	        String selectedValue = autoCompleteInput.getAttribute("value");
	        assert selectedValue.equals("India") : "Expected value not selected!";
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
