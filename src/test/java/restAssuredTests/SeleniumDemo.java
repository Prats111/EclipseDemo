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
	         DesiredCapabilities caps = new DesiredCapabilities();
	         caps.setCapability("browserName", "chrome");
	         caps.setCapability("platformName", "Windows 11");
	         caps.setCapability("browserVersion", "latest");
	         caps.setCapability("name", "MySauceLabsTest");
	         WebDriver driver = new RemoteWebDriver(
	                 new URL("https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub"),
	                 caps
	             );
	         driver.get("http://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	        driver.quit();	        
	    }

	  
}
