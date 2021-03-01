package mavenAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage  extends Base{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException{
		driver.get(p.getProperty("url"));
		LandingPage l=new LandingPage(driver);
	
		LoginPage lp=l.getSignin();
		//driver.findElement.Bycss
		log.info("In login page");
		lp.getEmail().sendKeys(username);
		lp.getPass().sendKeys(password);
		System.out.println(text);
		ForgotPassword f=lp.ForgotPass();
		System.out.println("forgot pass");
		f.getEmail().sendKeys("abc@com");
		Thread.sleep(3000);
		System.out.println("entered email");
		f.getSendMeInstr().click();
		
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data =new Object[2][3];
		log.info("Getting data in login page");
		data[0][0]="divya@.com";
		data[0][1]="12345";
		data[0][2]="Restricted";
		data[1][0]="arora@.com";
		data[1][1]="98765";
		data[1][2]="Unrestricted";
		
		return data;
	}
	@AfterTest
	public void AfterTest1() {
		driver.close();
	}

}
