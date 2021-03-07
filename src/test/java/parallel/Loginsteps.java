package parallel;

import org.junit.Assert;

import com.pages.Loginpage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Loginsteps {

private  Loginpage  loginpage= new Loginpage(DriverFactory.getDriver());
private static String  title;
@Given("user is on logins page")
public void user_is_on_logins_page() {
	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
	 title = loginpage.getLoginpagetitle();
	System.out.println();
}

@Then("page title should be {string}")
public void page_title_should_be(String titlename) {
	title = loginpage.getLoginpagetitle();
    Assert.assertTrue(title.contains(titlename));
}



@Then("forgot your password link should be diaplayed")
public void forgot_your_password_link_should_be_diaplayed() {
   Assert.assertTrue( loginpage.forgotpasswordlinkexist());
}

@When("user enters username {string}")
public void user_enters_username(String username) {
    loginpage.enterusername(username);
}

@When("user enters  password {string}")
public void user_enters_password(String password) {
	loginpage.enterpassword(password);
 
}

@Then("user clicks on Login button")
public void user_clicks_on_login_button() {
    loginpage.clickOnLogin();
}



	}


