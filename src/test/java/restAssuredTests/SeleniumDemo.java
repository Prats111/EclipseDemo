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
	    	
	    	String username = System.getenv("SAUCE_USERNAME");
	    	String accessKey = System.getenv("SAUCE_ACCESS_KEY");
	    	
	    	ChromeOptions browserOptions = new ChromeOptions();
	    	browserOptions.setPlatformName("Windows 11");
	    	browserOptions.setBrowserVersion("latest");
	    	Map<String, Object> sauceOptions = new HashMap<>();
	    	sauceOptions.put("username", username);
	    	sauceOptions.put("accessKey", accessKey);
	    	browserOptions.setCapability("sauce:options", sauceOptions);

	    	// start the session
	    	URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	    	RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

	         driver.get("http://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();	        
	    }

	  
}
