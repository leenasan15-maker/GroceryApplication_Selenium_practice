package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ScreenshotUtility;


public class Base {
Properties prop;
FileInputStream fileinput;
	public WebDriver driver;
   @BeforeMethod(alwaysRun=true)
   @Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{
	   prop=new Properties();
	   fileinput=new FileInputStream(Constant.CONFIGFILE);
	   prop.load(fileinput);
	   if(browsers.equalsIgnoreCase("Chrome"))
	{
		   driver=new ChromeDriver();	   
	   }else if(browsers.equalsIgnoreCase("Firefox"))
	   {
		   driver=new FirefoxDriver();
	   }else if(browsers.equalsIgnoreCase("Edge"))
	   {
		   WebDriverManager.edgedriver();
		   driver=new EdgeDriver();
	   }	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
   @AfterMethod(alwaysRun=true)
   public void closeBrowser(ITestResult itestresult) throws IOException{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}

}
