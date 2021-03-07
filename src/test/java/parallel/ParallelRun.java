package parallel;


import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;





	@CucumberOptions(
			
			plugin= {"pretty","rerun:target/surefire-reports/testng-results.txt",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/"
					},
					glue= {"parallel"},
					features ="./src/test/resources/parallel/contact.feature"
					,
			monochrome=true,
			
			dryRun = false
					)

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
