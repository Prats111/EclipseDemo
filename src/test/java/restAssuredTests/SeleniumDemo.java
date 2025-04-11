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
	         String sauceURL = "https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	         DesiredCapabilities capabilities = new DesiredCapabilities();
	         capabilities.setBrowserName("chrome");
	         capabilities.setCapability("platform", "Windows 10");
	         capabilities.setCapability("version", "latest");
	         capabilities.setCapability("name", "Sample Test");
	         WebDriver driver = new RemoteWebDriver(new URL(sauceURL), capabilities);

	         
	    	  driver.manage().window().maximize();

	        // Navigate to the application URL
	        driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();	        
	    }

	  
}
