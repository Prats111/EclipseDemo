package restAssuredTests;

import org.testng.annotations.BeforeMethod;
import java.net.URL;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemo {
	
	

	    @Test
	    public void setUp() throws MalformedURLException {
//	    	 DesiredCapabilities capabilities = DesiredCapabilities();
//	         capabilities.setCapability("platform", "Windows 10");
//	         capabilities.setCapability("version", "latest");
//	         capabilities.setCapability("name", "Sample Test");

	    	String username = System.getenv("SAUCE_USERNAME");
	        String accessKey = System.getenv("SAUCE_ACCESS_KEY");
	        String sauceURL = "https://" + username + ":" + accessKey + "@ondemand.saucelabs.com/wd/hub";

	    	ChromeOptions browserOptions = new ChromeOptions();
	    	browserOptions.setPlatformName("Windows 8.1");
	    	browserOptions.setBrowserVersion("latest");
	    	Map<String, Object> sauceOptions = new HashMap<>();
	    	sauceOptions.put("username", username);
	    	sauceOptions.put("accessKey", accessKey);
	    	sauceOptions.put("build", "23");
	    	sauceOptions.put("name", "demo");
	    	browserOptions.setCapability("sauce:options", sauceOptions);

//	    	// start the session
//    	URL url = new URL("https://oauth-pratikshya069-ebc02:8119ff65-a037-42a9-9ab2-c120a914e7a0@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    	RemoteWebDriver driver = new RemoteWebDriver(new URL(sauceURL), browserOptions);
//	    	WebDriverManager.chromedriver().setup();
//	    	WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Navigate to the application URL
	        driver.get("https://www.google.com");
	        System.out.println(driver.getTitle());
	        System.out.flush(); 
	        driver.quit();	        
	    }

	  
}
