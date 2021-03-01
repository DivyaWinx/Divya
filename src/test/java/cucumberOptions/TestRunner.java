package cucumberOptions;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//give feature file and step defination location
//uncomment RunWith then it will treat as Junit test case
//@RunWith(Cucumber.class)
@CucumberOptions(
		//location of featues package, glue is a parameter to define step defination file(package name)
		//test runner and step defination should have same parent
		features="src/test/java/features",
		glue="stepDefination"
		)

//extends this Abstract class to treat it as TestNg test
public class TestRunner extends AbstractTestNGCucumberTests{

}
