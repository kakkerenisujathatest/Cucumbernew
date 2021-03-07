package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.Accountpage;
import com.pages.Loginpage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class AccountsPageSteps {
	
	private  Loginpage  loginpage= new Loginpage(DriverFactory.getDriver());
	private Accountpage accountspage;
	
	
	
	
	@Given("user had already logged in to application")
	public void user_had_already_logged_in_to_application(DataTable credTable) throws InterruptedException {
	  List<Map<String,String>> creditList =  credTable.asMaps();
	  String username = creditList.get(0).get("username");
	  String password = creditList.get(0).get("password");
	  DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	  
	 accountspage = loginpage.doLogin(username, password);
	 
	}

	
	@Given("user is  on Account page")
	public void user_is_on_account_page() {
		String title1 =accountspage.getaccountpagetitle();
		System.out.println("account page title " +title1);
 	}
	   
	

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectiontable) {
		List<String>expectedaccountlist = sectiontable.asList();
	    System.out.println("Expected accounts list"+ sectiontable.asList());
	    List<String>actualaccountsectionslist =  accountspage.getAccountsectionlist();
	    System.out.println("Actual accounts section list:" + actualaccountsectionslist);
	    Assert.assertTrue(expectedaccountlist.containsAll(actualaccountsectionslist));
	}

	@Then("accounts section count  should be {int}")
	public void accounts_section_count_should_be(Integer expectedcount) {
		Assert.assertTrue(accountspage.getAccountSectioncouunt()==expectedcount);
	    		
	}

}
