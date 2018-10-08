package test;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import config.BrowserConfig;
import config.ExcelConfig;
import config.ExcelFileReader;
import pages.LoginPageObject;

public class Login extends BrowserConfig {

	@Test
	public void login() {

		ExcelFileReader efr = new ExcelFileReader();

		List<String> excData = efr.excelReader();
		LoginPageObject login = new LoginPageObject(driver);
		try {
		//	login.clickLoginOption();
			System.out.println(excData.get(1));
			System.out.println(excData.get(2));
		    login.getUsername(excData.get(1));
			login.getPassword(excData.get(2));
			login.clickLoginButton();
			
		
		
		//driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys("dsds");

		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dsds");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
