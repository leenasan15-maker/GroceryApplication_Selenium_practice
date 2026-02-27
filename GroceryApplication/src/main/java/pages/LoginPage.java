package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {
	WaitUtility waitutility=new WaitUtility();
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//label[@for='remember']") WebElement remember;
	@FindBy(xpath="//button[@type='submit']") WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement textloginpage;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]") WebElement errmessage;
	
	public LoginPage enterUsername(String usernamevalue)
	{
		
		username.sendKeys(usernamevalue);
		return this;
	}
	public LoginPage enterPassword(String passwordvalue)
	{
		
		password.sendKeys(passwordvalue);
		return this;
	}
	public HomePage clickLogin()
	{
		waitutility.waitUntilElementToBeClickable(driver, signin);
		signin.click();
		return new HomePage(driver);
	}
	public boolean verifyDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
public String verifygetTextofmartSupermarket()
	{
		return textloginpage.getText();
	} 
	
	
	 public String getErrorMessage() {
	     String s=errmessage.getText();
	     return s.replace("×", "").replace("Alert!", "").trim();
	    }
	 public boolean isErrorMessageDisplayed() {
	        return errmessage.isDisplayed();
	    }
}
