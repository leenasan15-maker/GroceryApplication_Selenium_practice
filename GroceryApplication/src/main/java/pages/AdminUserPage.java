package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;


public class AdminUserPage {
	PageUtility pageutility=new PageUtility();
public WebDriver driver;
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=' New' and @class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(id="user_type") WebElement usertype;
	@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement save;
	@FindBy(xpath="//i[@class='icon fas fa-check']") WebElement successalert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary' and @onclick='click_button(2)']") WebElement search;
	@FindBy(xpath="//input[@id='un']") WebElement searchusername;
	@FindBy(xpath="//select[@id='ut']") WebElement searchusertype;
	@FindBy(xpath="//button[@type='submit' and @name='Search']") WebElement searchbutton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement searchresultediticon;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()=' Reset']") WebElement resetbutton;
    @FindBy(xpath="//h4[@class='card-title' and text()='Admin Users']") WebElement resetlist;
		
	public AdminUserPage clickNewbutton()
	{
		
		newbutton.click();
		return this;
	}
	
	public AdminUserPage enterUsername(String usernamevalue)
	{
		
		username.sendKeys(usernamevalue);
		return this;
	}
	public AdminUserPage enterPassword(String passwordvalue)
	{
		
		password.sendKeys(passwordvalue);
		return this;
	}
	public AdminUserPage selectUserType()
	{
		pageutility.selectDropdownByVisibleText(usertype, "Staff");
		return this;
	}
	public AdminUserPage clickSavebutton()
	{
		
		save.click();
		return this;
	}
	public Boolean verifySuccesMessageDisplayed() {
		return successalert.isDisplayed();
	}

	public AdminUserPage clickSearch()
	{	
		search.click();
		return this;
	}
	public AdminUserPage enterSearchUsername(String searchusernamevalue)
	{
		
		searchusername.sendKeys(searchusernamevalue);
		return this;
	}
	
	public AdminUserPage searchUsertype()
	{
		pageutility.selectDropdownByVisibleText(searchusertype, "Staff");
		return this;
	}
	public AdminUserPage Search() {
		searchbutton.click();
		return this;
		
	}

	public boolean isSearchedUserDisplayed(String searchusernamevalue) {
		
			return searchusernamevalue.substring(0).matches(searchusernamevalue);
		}
	public AdminUserPage clickReset()
	{
		resetbutton.click();
		return this;
	}
	public boolean resetList()
	{
	 return resetlist.isDisplayed();
	
	}

		
}
