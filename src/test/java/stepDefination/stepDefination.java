package stepDefination;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination  extends Base{

    @Given("^Initialise the browser with Chrome$")
    public void initialise_the_browser_with_chrome() throws Throwable {
    	driver=initializeDriver();
    }

    @When("^User login into login page with (.+) and (.+)$")
    public void user_login_into_login_page_with_and(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
    	lp.getEmail().sendKeys(username);
		lp.getPass().sendKeys(password);
		lp.getLogin().click();
    }

    @Then("^verify the user is successfully logged in$")
    public void verify_the_user_is_successfully_logged_in() throws Throwable {
       System.out.println("validated");
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^click on Sign in button to land on sign in page$")
    public void click_on_sign_in_button_to_land_on_sign_in_page() throws Throwable {
    	LandingPage l=new LandingPage(driver);
    	if(l.getPopupSize()>0) {
			l.getPopup().click();
		}
		LoginPage lp=l.getSignin();
    }
    
    @And("^close browser$")
    public void close_browser() throws Throwable {
       driver.quit();
    }

   

}