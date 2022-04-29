package pageMethods;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.Selecting_Flight;
import utilities.BasicMethods;

public class SelectingFlightMethods {
	AppiumDriver<MobileElement> driver;
	Selecting_Flight select;
	BasicMethods bm;

	public SelectingFlightMethods(AppiumDriver<MobileElement> d,ExtentTest test) {

		this.driver=d;
		select = new Selecting_Flight(driver);
		bm = new BasicMethods(test);

	}


	public void selectingFirstFlight() {
		bm.clickElement(select.getFlightOneSelected(), "First Flight Selected..");
		bm.clickElement(select.getPlanRadioBtn(), "Plan Selection");
		bm.clickElement(select.getBookNowBtn(), "Book Now Btn");	
	}

}
