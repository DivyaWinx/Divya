package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;
	public Properties p;
	public WebDriver initializeDriver() throws IOException {
		//if chrome, execute test cases in chrome, if IE execute in IE
		//Data driven for browsers from external properties file
		 p =new Properties();
		//need to give file path of data driven file
		FileInputStream file =new FileInputStream("C:\\Users\\divya.arora01\\eclipse-workspace\\mavenE2EProject\\src\\main\\java\\resources\\data.properties");
		p.load(file);
		String browserName=p.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\divya.arora01\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//ChromeOptions op=new ChromeOptions();
			//op.setHeadless(true);
			driver =new ChromeDriver();
			driver.get("https://www.google.com/");
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			//code to invoke firefox
		}
		else {
			//code to invoke other browsers
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//send driver object back so we can use it in other classes and test cases just by calling method
		return driver;
		
	}
	
	/*public void getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		//typecasting with Webdriver object
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source,new File(destination));
		
	}*/

}
