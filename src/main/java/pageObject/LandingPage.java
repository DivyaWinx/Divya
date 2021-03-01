package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebDriver driver;
	By signin=By.cssSelector("a[href*='sign_in']");
	By bar =By.cssSelector(".nav.navbar-nav.navbar-right");
	By title=By.xpath("//h2[text()='Featured Courses']");
	By popup= By.xpath("//button[text()='NO THANKS']");
		
	public LoginPage getSignin() {
		driver.findElement(signin).click();
	
		return new LoginPage(driver);
		
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(bar);
	}
	
	public int getPopupSize() {
		 return driver.findElements(popup).size();
	}
	public WebElement getPopup() {
		 return driver.findElement(popup);
	}
}
