package pageMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.HomePage;
import utilities.BasicMethods;
import utilities.ExcelData;

public class HomePageMethods {
	AppiumDriver<MobileElement> driver;
	HomePage home;
	BasicMethods bm;
	List<Map<String, String>> Method1;
	public HomePageMethods(AppiumDriver<MobileElement> d,ExtentTest test) throws IOException {
		this.driver=d;
		home = new HomePage(driver);
		bm = new BasicMethods(test);
		Method1=ExcelData.getexceldatainMap(0);
	}	

	public void flighLogoClick() {
		bm.clickElement(home.getClickMenus(), "Menu Btn");
		bm.clickElement(home.getSelectFlightLogo(), "Flight Logo");
	}

	public void tripType() {
		bm.clickElement(home.getOneWayTicket(), "OneWay Btn");
	}
	
	public void sourceCity(String sourceCity) {
		bm.clickElement(home.getSourceCityBtn(), "Source City Btn");	
		bm.sendKeyElement(home.getSourceCityName(), sourceCity, "Source City Name");	
		bm.clickElement(home.getSelectCity(), "Selecting Source City");
	}
	
	public void destinationCity(String destinationCity) {
		bm.clickElement(home.getDestCityBtn(), "Destination City Btn");
		bm.sendKeyElement(home.getSelectdestCityName(), destinationCity,"Destination City Name");
		bm.clickElement(home.getSelectdestCity(), "Selecting Destination City");
	}
	
	public void deparrtureDate() {
		bm.clickElement(home.getSelectDepDateBtn(), "Date Btn");
		bm.scrollToText("July 2022");
		bm.clickElement(home.getSelectDepDate(), home.getSelectDepDate().getText());
	}
	
	public void passengerCount() {
		bm.clickElement(home.getPassangerCountBtn(), "Passenger Btn");
		bm.clickElement(home.getNoOfPassanger(), "No of Passengers");
		bm.clickElement(home.getPassangerDoneBtn(), "Passenger Done Btn");
	}
	
	public void flightClass() {
		bm.clickElement(home.getClassBtn(), "Class Btn");
		bm.clickElement(home.getSelectClass(), "Selecting Class");
	}
	
	public void searchBtn() {
		bm.clickElement(home.getSearchFlightBtn(), "Searching Flight ");
	}
}
