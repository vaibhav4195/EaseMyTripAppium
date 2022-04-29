package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TravellersDetails {
	
	//Constructor
	public TravellersDetails(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(id="com.easemytrip.android:id/tv_add_adult")
	private WebElement addAdultPassenger;
	
	@FindBy(id="com.easemytrip.android:id/rb_mr_adult")
	private WebElement mrAbr;
	
	@FindBy(id="com.easemytrip.android:id/input_first_name")
	private WebElement firstName;
	
	@FindBy(id="com.easemytrip.android:id/input_last_name")
	private WebElement lastName;
	
	@FindBy(id="com.easemytrip.android:id/btn_save_traveler")
	private WebElement saveTravellerBtn;
	
	@FindBy(id="com.easemytrip.android:id/input_email")
	private WebElement email;
	
	@FindBy(id="com.easemytrip.android:id/input_mobile")
	private WebElement mobileNumber;
	
	@FindBy(id="com.easemytrip.android:id/btn_paymentBooking")
	private WebElement ctnToPayBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Payment Options']")
	private WebElement paymentOptionText;

	//Setters and Getters
	
	public WebElement getAddAdultPassenger() {
		return addAdultPassenger;
	}

	public void setAddAdultPassenger(WebElement addAdultPassenger) {
		this.addAdultPassenger = addAdultPassenger;
	}

	public WebElement getMrAbr() {
		return mrAbr;
	}

	public void setMrAbr(WebElement mrAbr) {
		this.mrAbr = mrAbr;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}

	public WebElement getSaveTravellerBtn() {
		return saveTravellerBtn;
	}

	public void setSaveTravellerBtn(WebElement saveTravellerBtn) {
		this.saveTravellerBtn = saveTravellerBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getCtnToPayBtn() {
		return ctnToPayBtn;
	}

	public void setCtnToPayBtn(WebElement ctnToPayBtn) {
		this.ctnToPayBtn = ctnToPayBtn;
	}

	public WebElement getPaymentOptionText() {
		return paymentOptionText;
	}

	public void setPaymentOptionText(WebElement paymentOptionText) {
		this.paymentOptionText = paymentOptionText;
	}
	
	

}
