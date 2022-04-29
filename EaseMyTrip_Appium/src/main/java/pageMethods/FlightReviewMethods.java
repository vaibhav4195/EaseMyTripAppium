package pageMethods;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.FlightReview;
import utilities.BasicMethods;

public class FlightReviewMethods {


	AppiumDriver<MobileElement> driver;
	FlightReview review;
	BasicMethods bm;

	public FlightReviewMethods(AppiumDriver<MobileElement> d,ExtentTest test) {

		this.driver=d;
		review = new FlightReview(driver);
		bm = new BasicMethods(test);

	}



	public void flightReview() {
		bm.clickElement(review.getContinueBookingBtn(), "Continue Booking Btn");
		bm.clickElement(review.getInsureRadioBtn(), "Not Insured Btn");
		bm.clickElement(review.getContinueBookingBtn(), "Continue Booking Btn");
	}
}
