package mavenAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;

import resources.Base;

public class validateTitle  extends Base{
	WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is intialized");
		driver.get(p.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException{
		LandingPage l=new LandingPage(driver);
		log.info("Navigated to Home Page");
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Successfully validated");
			
		
	}
	
	@AfterTest
	public void AfterTest1() {
		driver.close();
	}
	
}
