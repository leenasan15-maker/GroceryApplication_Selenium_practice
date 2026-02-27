package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base {
	   HomePage homepage;
	@Test(description="user is trying to logout")
	public void verifyUserIsAbletoLogOutSuccessfully() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
	    homepage.clickAdmin();
		loginpage=homepage.clickLogout();
		String expected="7rmart supermarket";
		String actual=loginpage.verifygetTextofmartSupermarket();
		Assert.assertEquals(actual, expected,Constant.USERLOGOUTERROR);
	}
}
