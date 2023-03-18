package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class HomePage extends TestBase{
	@Test
	public void clickOptions() {
		click("hamburg_home_page_XPATH");
		click("login_button_XPATH");
		
	}
	public void Login() {
		
	}
}
	
