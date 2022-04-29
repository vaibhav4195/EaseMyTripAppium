package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import utilities.Base;


public class BookTicket extends Base {
	@Test(priority = 1)
	public void bookFlightFirstPage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.easemytrip.android:id/iv_drwer").click();
		//Selecting source and destination cities
		driver.findElementByXPath("//android.widget.TextView[@text='Flights']").click();
		System.out.println("Clicked on Flights Button");
		driver.findElementById("com.easemytrip.android:id/rdbOneway").click();
		System.out.println("Selected one way trip");
		driver.findElementById("com.easemytrip.android:id/textView_city_fullname").click();
		System.out.println("Selecting source city");
		Thread.sleep(3000);

		driver.findElementById("com.easemytrip.android:id/search").sendKeys("mumbai");
		Thread.sleep(2000);
		driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/search_airport_list_item_name'])[1]").click();


		driver.findElementById("com.easemytrip.android:id/search_flight_destination_cityname").click();
		System.out.println("Selecting destination city");
		Thread.sleep(3000);

		driver.findElementById("com.easemytrip.android:id/search").sendKeys("goa");
		Thread.sleep(2000);
		driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/search_airport_list_item_name'])[1]").click();

		//Selecting Date
		driver.findElementById("com.easemytrip.android:id/search_flight_departure_date").click();
		String scrollToMonth = "July 2022";
		MobileElement date = null;
		try {
			String uiSelector = "new UiSelector().textMatches(\"" + scrollToMonth
					+ "\")";

			String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
					+ uiSelector + ")";

			driver.findElement(MobileBy.AndroidUIAutomator(command));
			date = driver.findElementByXPath("(//android.widget.TextView[@text='20'])[1]");	
			if(date.isDisplayed()==false) {
				date = driver.findElementByXPath("//android.widget.TextView[@content-desc='Date is 20 Jun 2022']");
			}
							
		} catch (NoSuchElementException e) {
			System.out.println("Catch Block");
			System.out.println("Catch Block end");
		}
		date.click();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+scrollToMonth+"\"))"));
		//		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+scrollToMonth+"\").instance(0))"));
//		MobileElement date = driver.findElementByXPath("//android.widget.TextView[@content-desc='Date is 15 Jun 2022']");
//		date.click();

		//Select number of passengers
		System.out.println("//Select number of passengers");
		driver.findElementById("com.easemytrip.android:id/textViewPaxCount").click();
		driver.findElementById("com.easemytrip.android:id/adult_two").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Done']").click();


		//select Class
		System.out.println("//select Class");
		driver.findElementByXPath("(//android.widget.TextView[@resource-id='android:id/text1'])[1]").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Business']").click();

		driver.findElementById("com.easemytrip.android:id/button_flight_Search").click();
	}

	@Test(priority = 2)
	public void bookFlightSecondPage() throws InterruptedException{
		System.out.println("Seconds Test");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("(//android.widget.RelativeLayout[@resource-id='com.easemytrip.android:id/top_layout'])[1]").click();
		driver.findElementByXPath("(//android.widget.RadioButton[@resource-id='com.easemytrip.android:id/rdbCheck'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_booknow'])[1]").click();
		//		driver.findElementByXPath("(//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_booknow'])[1]").click();
	}
	
	@Test(priority = 3)
	public void bookFlightThirdPage() throws InterruptedException{
		driver.findElementById("com.easemytrip.android:id/btn_paymentBooking").click();
		driver.findElementById("com.easemytrip.android:id/radioButton_no").click();
		driver.findElementById("com.easemytrip.android:id/btn_paymentBooking").click();
	}
	
	@Test(priority = 4)
	public void bookFlightFourthPage() throws InterruptedException{
		driver.findElementById("com.easemytrip.android:id/tv_add_adult").click();
		driver.findElementById("com.easemytrip.android:id/rb_mr_adult").click();
		driver.findElementById("com.easemytrip.android:id/input_first_name").sendKeys("Vaibhav");
		driver.findElementById("com.easemytrip.android:id/input_last_name").sendKeys("Pawde");
		driver.findElementById("com.easemytrip.android:id/btn_save_traveler").click();
		Thread.sleep(3000);
		driver.findElementById("com.easemytrip.android:id/tv_add_adult").click();
		driver.findElementById("com.easemytrip.android:id/rb_mr_adult").click();
		driver.findElementById("com.easemytrip.android:id/input_first_name").sendKeys("Manish");
		driver.findElementById("com.easemytrip.android:id/input_last_name").sendKeys("Shah");
		driver.findElementById("com.easemytrip.android:id/btn_save_traveler").click();
		Thread.sleep(2000);
		String scrollUpto = "I Accept T&C and Privacy Policy";
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+scrollUpto+"\").instance(0))"));
		driver.findElementById("com.easemytrip.android:id/input_email").sendKeys("abc@xyz.com");
		driver.findElementById("com.easemytrip.android:id/input_mobile").sendKeys("7645354225");
		driver.findElementById("com.easemytrip.android:id/btn_paymentBooking").click();
		Thread.sleep(3000);
		
		MobileElement payment =driver.findElementByXPath("//android.widget.TextView[@text='Payment Options']");
		Assert.assertEquals(payment.isDisplayed(), true);
		
	}

}
