package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By menuBy=By.xpath("//img[@alt='menu']");
	
	private By loginOption=By.xpath("//button[normalize-space()='Log in']");
	
	private	By username=By.xpath("//input[@id='email1']");
	
	private By password=By.xpath("//input[@id='password1']");
	
	private	By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	
	private By loginSignInOption=By.xpath("//h2[normalize-space()='Sign In']");
	
	private By socialMediaCount=By.xpath("//div[@class='social-btns']//a");
	
	public void loginOption() 
	{
		driver.findElement(menuBy).click();
		
		driver.findElement(loginOption).click();
	}
	
	public HomePage loginToApplication(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		HomePage home=new HomePage(driver);
		
		return home;
		
	}
	
	public int numberOfSocialMediaIcons() {
		
		return driver.findElements(socialMediaCount).size();
		
	}
	
	public boolean isSignInDisplayed() 
	{
		return driver.findElement(loginSignInOption).isDisplayed();
	}
		
}



