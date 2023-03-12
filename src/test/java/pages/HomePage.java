package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class HomePage extends TestBase{
	@Test
	public void clickOptions() {
//		driver.findElement(By.xpath("//*[@id=\"innerApp\"]/div[2]/header/div/div")).click();
//		driver.findElement(By.xpath("//*[@id=\"innerApp\"]/div[2]/div/div[2]/div[1]/div[1]/button")).click();
		click("hamburg_home_page_XPATH");
		click("login_button_XPATH");
	}
	
}
