package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	private WebDriver driver;
	
	//By locatars
	private By emailID =By.id("email");
	private By password =By.id("passwd");
	private By signInButton =By.id("SubmitLogin");
	private By forgotpwdlink = By.linkText("Forgot your password?");
	
	
	//constuctor of the page
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
		//page actions
		public String getLoginpagetitle() {
			return driver.getTitle();
			
			
		}
		
		public boolean forgotpasswordlinkexist() {
		return	driver.findElement(forgotpwdlink).isDisplayed();
		}
		
		public void enterusername(String username) {
			driver.findElement(emailID).sendKeys(username);
			
		}
		public void enterpassword(String pwd) {
			driver.findElement(password).sendKeys(pwd);
			
		}
		
		public void clickOnLogin() {
			driver.findElement(signInButton).click();
			
		}
		public Accountpage doLogin(String un, String pw) throws InterruptedException {
			
			driver.findElement(emailID).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(signInButton).click();
			Thread.sleep(5000);
			return new Accountpage(driver);
		}
		
		
			
		
	}
	
	

