package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FlightReview {
	
	public FlightReview(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.easemytrip.android:id/btn_paymentBooking")
	private WebElement continueBookingBtn;
	
	@FindBy(id="com.easemytrip.android:id/radioButton_no")
	private WebElement insureRadioBtn;

	public WebElement getContinueBookingBtn() {
		return continueBookingBtn;
	}

	public void setContinueBookingBtn(WebElement continueBookingBtn) {
		this.continueBookingBtn = continueBookingBtn;
	}

	public WebElement getInsureRadioBtn() {
		return insureRadioBtn;
	}

	public void setInsureRadioBtn(WebElement insureRadioBtn) {
		this.insureRadioBtn = insureRadioBtn;
	}
	
	

}
