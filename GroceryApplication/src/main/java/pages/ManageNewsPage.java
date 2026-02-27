package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement clicknew;
	@FindBy(xpath="//textarea[@id='news' and @name='news']") WebElement enternews;
	@FindBy(xpath="//button[@type='submit' and text()='Save']") WebElement save;
	@FindBy(xpath="//i[@class='icon fas fa-check']") WebElement successalert;
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(2)']") WebElement clicksearch;
	@FindBy(xpath="//input[@type='text' and @placeholder='Title']") WebElement enternewstosearch;
	@FindBy(xpath="//button[@type='submit' and @name='Search']") WebElement searchnow;
	
	public ManageNewsPage clickNew()
	{
		clicknew.click();
		return this;
	}

	public ManageNewsPage enterNews(String enterednews) {
		enternews.sendKeys(enterednews);
		return this;
	}

	public ManageNewsPage saveNews() {
		save.click();
		return this;
		
	}

	public Boolean verifySuccesMessageDisplayed() {
		return successalert.isDisplayed();
	}

	public ManageNewsPage clickSearch(){
		clicksearch.click();
		return this;
	}

 public ManageNewsPage enterNewstoSearch(String news) {
	 
	 enternewstosearch.sendKeys(news);
	 return this;
	}
 
	public ManageNewsPage searchNow()
	{
		searchnow.click();
		return this;
	}

	public Boolean verifySearchResultDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isSearchedUserDisplayed(String searchnews) {
			
			return searchnews.substring(0).matches(searchnews);

	}
}
