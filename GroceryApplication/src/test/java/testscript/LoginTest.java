package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;
	@Test(priority=1,description="user is trying to login with vlid credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1,0,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		Boolean dashboard=loginpage.verifyDashboardDisplayed();
		assertTrue(dashboard,Constant.VALIDCREDENTIALERROR);

	}
	@Test(priority=2,description="user is trying to login with valid username an invalid password",retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameandInvalidPassword() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickLogin();
	//Assert.assertTrue(loginpage.isErrorMessageDisplayed(), "User is able to login with invalid credentials");
	String expected= "Invalid Username/Password";
	String actual=loginpage.getErrorMessage();
    //System.out.println("Error message :"+actual);
    Assert.assertEquals(actual,expected,Constant.VALIDUSERNAMEINVALIDPASSWORDCREDENTIALERROR);
	}
	
	@Test(priority=3,description="user is trying to login with invalid username an valid password")
	public void verifyUserLoginWithInvalidUsernameandvalidPassword() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
	String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickLogin();
	String expected= "Invalid Username/Password";
	String actual=loginpage.getErrorMessage();
    //System.out.println("Error message :"+actual);
    Assert.assertEquals(actual,expected,Constant.INVALIDUSERNAMEVALIDPASSWORDCREDENTIALERROR);
//	Assert.assertTrue(loginpage.isErrorMessageDisplayed(), "User is able to login with invalid credentials");
	}
	@Test(priority=4,description="user is trying to login with invalid username an invalid password",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyUserLoginWithInvalidUsernameandInvalidPassword(String usernamevalue,String passwordvalue) throws IOException
	{
	//String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
	//String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickLogin();
	//Assert.assertTrue(loginpage.isErrorMessageDisplayed(), "User is able to login with invalid credentials");
	String expected= "Invalid Username/Password";
	String actual=loginpage.getErrorMessage();
    //System.out.println("Error message :"+actual);
    Assert.assertEquals(actual,expected,Constant.INVALIDUSERNAMEINVALIDPASSWORDCREDENTIALERROR);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
