package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int EXPLICITWAIT=5;
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilElementVisible(WebDriver driver, WebElement element) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilElementInvisible(WebDriver driver, WebElement element) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitUntilElementSelected(WebDriver driver, WebElement element) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitUntilAttributeContains(WebDriver driver, WebElement element, 
            String attribute, String value) {
		
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
     wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	public void waitUntilTextPresentInElement(WebDriver driver, WebElement element, String text) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitUntilTextPresentInElement1(WebDriver driver, WebElement element, String text) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// hw - 5 methods - ExpectedConditions.

}
