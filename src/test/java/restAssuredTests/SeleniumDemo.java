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
	    	
	    	ChromeOptions browserOptions = new ChromeOptions();
	    	browserOptions.setPlatformName("Windows 11");
	    	browserOptions.setBrowserVersion("latest");
	    	Map<String, Object> sauceOptions = new HashMap<>();
	    	sauceOptions.put("username", "oauth-pratikshya069-ebc02");
	    	sauceOptions.put("accessKey", "734783e4-2f59-44d4-8aed-7d947f118825");
	    	sauceOptions.put("build", "11");
	    	sauceOptions.put("name", "demo1");
	    	browserOptions.setCapability("sauce:options", sauceOptions);
	    	String sauceURL = "https://oauth-pratikshya069-ebc02:734783e4-2f59-44d4-8aed-7d947f118825@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	        
	    	// start the session
	    	URL url = new URL(sauceURL);
	    	RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

 
//	    	 String username = System.getenv("SAUCE_USERNAME");
//	         String accessKey = System.getenv("SAUCE_ACCESS_KEY");
//	         if (username == null || accessKey == null) {
//	             throw new IllegalStateException("Sauce Labs credentials are not set in environment variables.");
//	         }
//	    	String username = "oauth-pratikshya069-ebc02";
//	    	 String accessKey = "734783e4-2f59-44d4-8aed-7d947f118825";
//	         String sauceURL = "https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
//	         DesiredCapabilities capabilities = new DesiredCapabilities();
//	         capabilities.setBrowserName("chrome");
//	         capabilities.setCapability("platform", "Windows 10");
//	         capabilities.setCapability("version", "latest");
//	         capabilities.setCapability("name", "Sample Test");
//	         WebDriver driver = new RemoteWebDriver(new URL(sauceURL), capabilities);

	         
	    	  driver.manage().window().maximize();

	        // Navigate to the application URL
	        driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();	        
	    }

	  
}
