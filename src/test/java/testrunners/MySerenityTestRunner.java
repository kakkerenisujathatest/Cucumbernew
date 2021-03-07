package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features ={"./src/test/resources/parallel/contact.feature"},
		glue= {"parallel"},
		plugin ={"pretty"},
		monochrome=true,
		dryRun = false
				)
public class MySerenityTestRunner {

	
}
