package pages;

import java.awt.Button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Admin") WebElement admin;
	@FindBy(linkText="Logout") WebElement logout;
	@FindBy(xpath="//a[text()='More info ' and @href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\"]") WebElement adminusersmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenews;
	public HomePage clickAdmin()
	{
		admin.click();
		return this;
	}
	public LoginPage clickLogout()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUserPage clickadminusersMoreinfo()
	{
		adminusersmoreinfo.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage clickManageNews()
	{
		managenews.click();
		return new ManageNewsPage(driver);
	}
	
	
}
