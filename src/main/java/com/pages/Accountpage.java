package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accountpage {
	private WebDriver driver;
	private By accountsSections = By.cssSelector("div#center_column span");
	
	public  Accountpage(WebDriver driver) {
	this.driver =driver;
	
	}
	
	
	
	public int getAccountSectioncouunt() {
	return	driver.findElements(accountsSections).size();
		
	}
	
	
	
	
	public List<String> getAccountsectionlist() {
		List<String> accountlist = new ArrayList<>();
		List<WebElement> accountHeaderlist = driver.findElements(accountsSections);
		for(WebElement e : accountHeaderlist ) {
		String text =	e.getText();
		
		System.out.println(text);
		accountlist.add(text);
		}
		return accountlist;
		
	}



	public String getaccountpagetitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	
	

}
