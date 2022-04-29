package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage {

	//1st step is to call the driver object from testcase to PageObject file
	//Concatenate driver
	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(driver, this);
	}

	//Locators
	//Source and Destination Selection
	@FindBy(id="com.easemytrip.android:id/iv_drwer")
	private WebElement clickMenus;

	@FindBy(xpath="//android.widget.TextView[@text='Flights']")
	private WebElement selectFlightLogo;

	@FindBy(id="com.easemytrip.android:id/rdbOneway")
	private WebElement oneWayTicket;

	@FindBy(id="com.easemytrip.android:id/textView_city_fullname")
	private WebElement sourceCityBtn;

	@FindBy(id="com.easemytrip.android:id/search")
	private WebElement sourceCityName;

	@FindBy(xpath="(//android.widget.TextView[@resource-id='com.easemytrip.android:id/search_airport_list_item_name'])[1]")
	private WebElement selectCity;

	@FindBy(id="com.easemytrip.android:id/search_flight_destination_cityname")
	private WebElement destCityBtn;

	@FindBy(id="com.easemytrip.android:id/search")
	private WebElement selectDestCityName;

	@FindBy(xpath="(//android.widget.TextView[@resource-id='com.easemytrip.android:id/search_airport_list_item_name'])[1]")
	private WebElement selectDestCity;


	//Selecting Date

	@FindBy(id="com.easemytrip.android:id/search_flight_departure_date")
	private WebElement selectDepDateBtn;

	@FindAll({
		@FindBy(xpath="(//android.widget.TextView[@text='20'])[1]"),
		@FindBy(xpath="//android.widget.TextView[@content-desc='Date is 20 Jun 2022']")
	})private WebElement selectDepDate;

	
	//Select number of passengers
	@FindBy(id="com.easemytrip.android:id/textViewPaxCount")
	private WebElement passangerCountBtn;
	
	@FindBy(id="com.easemytrip.android:id/adult_one")
	private WebElement noOfPassanger;
	
	@FindBy(xpath="//android.widget.TextView[@text='Done']")
	private WebElement passangerDoneBtn;

	//select Class
	@FindBy(xpath="(//android.widget.TextView[@resource-id='android:id/text1'])[1]")
	private WebElement classBtn;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='Business']")
	private WebElement selectClass;
	
	@FindBy(id="com.easemytrip.android:id/button_flight_Search")
	private WebElement searchFlightBtn;
	
	
	//Setters And Getters
	public WebElement getSelectDestCityName() {
		return selectDestCityName;
	}

	public void setSelectDestCityName(WebElement selectDestCityName) {
		this.selectDestCityName = selectDestCityName;
	}

	public WebElement getSelectDestCity() {
		return selectDestCity;
	}

	public void setSelectDestCity(WebElement selectDestCity) {
		this.selectDestCity = selectDestCity;
	}

	public WebElement getSelectDepDateBtn() {
		return selectDepDateBtn;
	}

	public void setSelectDepDateBtn(WebElement selectDepDateBtn) {
		this.selectDepDateBtn = selectDepDateBtn;
	}

	public WebElement getSelectDepDate() {
		return selectDepDate;
	}

	public void setSelectDepDate(WebElement selectDepDate) {
		this.selectDepDate = selectDepDate;
	}

	public WebElement getDestCityBtn() {
		return destCityBtn;
	}

	public void setDestCityBtn(WebElement destCityBtn) {
		this.destCityBtn = destCityBtn;
	}

	public WebElement getSelectdestCityName() {
		return selectDestCityName;
	}

	public void setSelectdestCityName(WebElement selectdestCityName) {
		this.selectDestCityName = selectdestCityName;
	}

	public WebElement getSelectdestCity() {
		return selectDestCity;
	}

	public void setSelectdestCity(WebElement selectdestCity) {
		this.selectDestCity = selectdestCity;
	}

	public WebElement getClickMenus() {
		return clickMenus;
	}

	public void setClickMenus(WebElement clickMenus) {
		this.clickMenus = clickMenus;
	}

	public WebElement getSourceCityName() {
		return sourceCityName;
	}

	public void setSourceCityName(WebElement sourceCityName) {
		this.sourceCityName = sourceCityName;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public void setSelectCity(WebElement selectCity) {
		this.selectCity = selectCity;
	}

	public WebElement getSelectFlightLogo() {
		return selectFlightLogo;
	}

	public void setSelectFlightLogo(WebElement selectFlightLogo) {
		this.selectFlightLogo = selectFlightLogo;
	}

	public WebElement getOneWayTicket() {
		return oneWayTicket;
	}

	public void setOneWayTicket(WebElement oneWayTicket) {
		this.oneWayTicket = oneWayTicket;
	}

	public WebElement getSourceCityBtn() {
		return sourceCityBtn;
	}

	public void setSourceCityBtn(WebElement sourceCityBtn) {
		this.sourceCityBtn = sourceCityBtn;
	}
	
	public WebElement getPassangerCountBtn() {
		return passangerCountBtn;
	}

	public void setPassangerCountBtn(WebElement passangerCountBtn) {
		this.passangerCountBtn = passangerCountBtn;
	}

	public WebElement getNoOfPassanger() {
		return noOfPassanger;
	}

	public void setNoOfPassanger(WebElement noOfPassanger) {
		this.noOfPassanger = noOfPassanger;
	}

	public WebElement getPassangerDoneBtn() {
		return passangerDoneBtn;
	}

	public void setPassangerDoneBtn(WebElement passangerDoneBtn) {
		this.passangerDoneBtn = passangerDoneBtn;
	}

	public WebElement getClassBtn() {
		return classBtn;
	}

	public void setClassBtn(WebElement classBtn) {
		this.classBtn = classBtn;
	}

	public WebElement getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(WebElement selectClass) {
		this.selectClass = selectClass;
	}

	public WebElement getSearchFlightBtn() {
		return searchFlightBtn;
	}

	public void setSearchFlightBtn(WebElement searchFlightBtn) {
		this.searchFlightBtn = searchFlightBtn;
	}

	
}
