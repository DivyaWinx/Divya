package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	
	By email=By.id("user_email");
	By pass=By.id("user_password");
	By login= By.cssSelector("[name='commit']");
	By forgotPass= By.cssSelector("[href*='password/new']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPass() {
		return driver.findElement(pass);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
		
	}
	public ForgotPassword ForgotPass() {
		driver.findElement(forgotPass).click();
		return new ForgotPassword(driver);
	}
}
