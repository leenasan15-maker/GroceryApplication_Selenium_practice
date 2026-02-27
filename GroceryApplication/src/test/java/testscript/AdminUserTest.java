package testscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.RandomDataUtility;

public class AdminUserTest extends Base{
	HomePage homepage;
	AdminUserPage adminuserpage;
	@Test(description="user is trying to add new admin user")
	public void verifyNewUserAdminAddedSuccessfully() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		RandomDataUtility randomdatautility=new RandomDataUtility();
		adminuserpage=homepage.clickadminusersMoreinfo();
		String adminusernamevalue=randomdatautility.randomUsername();
		String adminpasswordvalue=randomdatautility.randomPassword();
		adminuserpage.clickNewbutton().enterUsername(adminusernamevalue).enterPassword(adminpasswordvalue).selectUserType().clickSavebutton();
		 Boolean useradd=adminuserpage.verifySuccesMessageDisplayed();
	     Assert.assertTrue(useradd, Constant.NEWUSERADDITIONERROR);
		
	}
	@Test(description="user is trying to search the newly added users")
	public void verifySearch() throws IOException 
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		adminuserpage=homepage.clickadminusersMoreinfo();
		String adminusernamevalue=ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		 adminuserpage.clickSearch().enterSearchUsername(adminusernamevalue).Search();
		 Boolean searchresult=adminuserpage.isSearchedUserDisplayed(adminusernamevalue);
	     Assert.assertTrue(searchresult,Constant.USERSEARCHERROR);
	
	}
	@Test
	public void reset() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		adminuserpage=homepage.clickadminusersMoreinfo();
		adminuserpage.clickReset();
		Boolean resetdone= adminuserpage.resetList();
		Assert.assertTrue(resetdone,Constant.RESETERROR);
		
	}
	
	
}
