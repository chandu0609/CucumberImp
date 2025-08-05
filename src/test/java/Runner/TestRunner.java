package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features", //Configure Feature folder
		glue= {"stepDefinitions"}, //Configure Step Def
		plugin ={"pretty","html:target/cucumber-report.html"},
		dryRun = false, //Execute to just map Gherkin line to method. If it true, it just checks. Doesn't execute
		monochrome = true //Cleaner report on Console while running
		
	
		)

public class TestRunner {

}
