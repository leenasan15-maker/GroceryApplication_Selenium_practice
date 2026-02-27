package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description="user is trying to add news")
	public void addNewsinfo() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		managenewspage=homepage.clickManageNews();
		
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenewspage.clickNew().enterNews(news).saveNews();
		Boolean successalert = managenewspage.verifySuccesMessageDisplayed();
		Assert.assertTrue(successalert,Constant.ADDNEWSERROR);
	}

	@Test(description="user is trying to search news")
	public void searchNewsInfo() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickLogin();
		managenewspage=homepage.clickManageNews();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenewspage.clickSearch().enterNewstoSearch(news).searchNow();
		 Boolean searchresult=managenewspage.isSearchedUserDisplayed(news);
	     Assert.assertTrue(searchresult,Constant.SEARCHNEWSERROR);

	}

}
