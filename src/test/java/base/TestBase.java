package base;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	@BeforeSuite
	public void setup() {
		if(driver == null) {
			// loading configuration of environment
			try {
				fis = new FileInputStream("./src/test/resources/properties/config.properties");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//load Object repositories (UI Elements)
			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// choosing browser environment
			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(config.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		driver.get("https://www.google.com/");
	}
	
	@AfterSuite
	public void TearDown() throws InterruptedException {
		if(driver!=null) {
			Thread.sleep(5000);
			driver.quit();
		}
	}
	
}
