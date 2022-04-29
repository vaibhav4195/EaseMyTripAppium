package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;

public class BasicMethods extends BaseWithServer{
//	WebDriverWait wait=new WebDriverWait(driver, 10);
	
	public BasicMethods(ExtentTest test) {
		BaseWithServer.test=test;
	}
	

	
	public void elementToBeClickable(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}



	private void elementTobeVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void clickElement(WebElement ele,String elename) {
		if(ele.isEnabled()==true) {
			elementToBeClickable(ele);
			ele.click();
			test.log(Status.INFO, "Clicked on Element: "+elename);
			System.out.println("Clicked on Element: "+elename);
		}else {
			System.out.println("Element is not Enable:"+elename);
			test.log(Status.FAIL, "Element is not Enable: "+elename);
		}		
	}
	
	public void sendKeyElement(WebElement ele,String message,String elename) {
		elementTobeVisible(ele);
		if(ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(message);
			test.log(Status.INFO, "Entered Text on: "+elename+", Entered Text :"+message);
			System.out.println("Entered Text on: "+elename+", Entered Text :"+message);
		}else {
			System.out.println("Element is not Displayed: "+elename);
			test.log(Status.FAIL, "Element is not Displayed "+elename);
		}		
	}
	
	public void scrollToText(String text) {
		WebElement scroll=  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.textToBePresentInElement(scroll, text));
		System.out.println("Scroll upto : "+text);
		test.log(Status.INFO, "Scroll upto : "+text);

	}	
	
	public static String configReader(String paramerter) throws IOException {
		String add=System.getProperty("user.dir") + "\\src\\main\\resources\\propertiesFile\\global.properties";
		FileInputStream file=new FileInputStream(add);
		Properties prop=new Properties();
		prop.load(file);
		String parm=prop.getProperty(paramerter);
		return parm;
		
		
	}
}
