package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.Contactpage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contactpagedefination {
	
	private Contactpage contactpage= new Contactpage(DriverFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}
	    
	
	

@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber_row_number(String sheetName , Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		
		ExcelReader reader = new ExcelReader();
		List <Map<String,String>>testdata = reader.getData("C:\\Users\\kakke\\OneDrive\\Desktop\\Eclipse\\automation.xlsx", sheetName);
	    
		String heading = testdata.get(rowNumber).get("subjectheading");
		String email =testdata.get(rowNumber).get("email");
	    String orderref1 =testdata.get(rowNumber).get("orderref");
	    String message =testdata.get(rowNumber).get("message");
	    
	    Thread.sleep(4000);
	    
	    contactpage.fillContactUsForm(heading, email, orderref1,  message);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {

	    contactpage.clickSend();  
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expsuccesmessage) {
	 String actualmessage =  contactpage.getSuccessMessg();
	 Assert.assertEquals(expsuccesmessage, actualmessage );

}
}