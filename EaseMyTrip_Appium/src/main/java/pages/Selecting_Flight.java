package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Selecting_Flight {


	
	public Selecting_Flight(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id='com.easemytrip.android:id/top_layout'])[1]")
	private WebElement flightOneSelected;
	
	@FindBy(xpath="(//android.widget.RadioButton[@resource-id='com.easemytrip.android:id/rdbCheck'])[1]")
	private WebElement planRadioBtn;
	
	@FindBy(xpath="(//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_booknow'])[1]")
	private WebElement bookNowBtn;

	public WebElement getFlightOneSelected() {
		return flightOneSelected;
	}

	public void setFlightOneSelected(WebElement flightOneSelected) {
		this.flightOneSelected = flightOneSelected;
	}

	public WebElement getPlanRadioBtn() {
		return planRadioBtn;
	}

	public void setPlanRadioBtn(WebElement planRadioBtn) {
		this.planRadioBtn = planRadioBtn;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public void setBookNowBtn(WebElement bookNowBtn) {
		this.bookNowBtn = bookNowBtn;
	}
	
	
	
}
