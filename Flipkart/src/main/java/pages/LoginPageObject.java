package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {
	WebDriver driver;

	/*By username1 = By.xpath("//input[@class='_2zrpKA']");
	By password1 = By.xpath("//input[@type='password']");
	By loginButton1 = By.xpath("//button[@type='submit']//span[contains(text(),'Login')]");
*/
	@FindBy(xpath = "//a[contains(text(),'Login & Signup')]")
	WebElement loginOption;

	@FindBy(xpath = "//input[@class='_2zrpKA']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Login')]")
	WebElement loginButton;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickLoginOption() {

		loginOption.click();

	}

	public void getUsername(String uid) {
		System.out.println("usename inside getUsername method : " + uid);

		// username.sendKeys("Admin");

		username.sendKeys(uid);

	}

	public void getPassword(String pass) {

		System.out.println("password inside getPassword method : " + pass);

	//	driver.findElement(password1).sendKeys(pass);
password.sendKeys(pass);
	}

	public void clickLoginButton() {

		 loginButton.click();

		//driver.findElement(loginButton1).click();

	}

}
