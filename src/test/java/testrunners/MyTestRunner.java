package testrunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
	@CucumberOptions(
			features ="./src/test/resources/features"
			,glue= {"stepdefination" ,"Apphooks"},
			plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/"},
			monochrome=true,
			
			dryRun = false
					)

public class MyTestRunner {
	
}