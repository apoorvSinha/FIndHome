package base;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public WebDriverWait wait;
	
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
		// setting browser window
		driver.get(config.getProperty("base_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf((config.getProperty("implcit_waits")))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.valueOf(config.getProperty("explicit_wait"))));
		
		
	}

	public WebElement LocatorIdentifier(String locator){
		if(locator.contains("XPATH")){
			return driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if(locator.contains("CSS")){
			return driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		return null;
	}
	
	public void click(String locator) {
		if(locator.contains("XPATH")){
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if(locator.contains("CSS")){
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
	}
	
	@AfterSuite
	public void TearDown() throws InterruptedException {
		if(driver!=null) {
			Thread.sleep(5000);
			driver.quit();
		}
	}
	
}
