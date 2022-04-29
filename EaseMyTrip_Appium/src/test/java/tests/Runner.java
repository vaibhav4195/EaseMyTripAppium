package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pageMethods.FlightReviewMethods;
import pageMethods.HomePageMethods;
import pageMethods.SelectingFlightMethods;
import pageMethods.TravellersDetailsMethods;
import utilities.BaseWithServer;
import utilities.ExcelData;

public class Runner extends BaseWithServer {

	List<Map<String, String>> Method1;
	@Test(priority = 0)
	public void homePage() throws IOException, InterruptedException {
		Method1=ExcelData.getexceldatainMap(0);
//		//Start a server
//		service = startServer();
//		//Open app capabilities and initialize driver
//		openApp1();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePageMethods hm = new HomePageMethods(driver, test);
		hm.flighLogoClick();
		hm.tripType();
		hm.sourceCity(Method1.get(0).get("Source City"));
		hm.destinationCity(Method1.get(0).get("Destination City"));
		hm.deparrtureDate();
		hm.passengerCount();
		hm.flightClass();
		hm.searchBtn();
	}
	
	@Test(priority = 1,dependsOnMethods = "homePage")
	public void flightSelection() {
		SelectingFlightMethods sm=new SelectingFlightMethods(driver, test);
		sm.selectingFirstFlight();
	}
	
	@Test(priority = 2,dependsOnMethods = "flightSelection")
	public void flightReview() {
		FlightReviewMethods fm=new FlightReviewMethods(driver, test);
		fm.flightReview();
	}
	
	@Test(priority = 3,dependsOnMethods = "flightReview")
	public void travellersDetails() throws IOException {
		Method1=ExcelData.getexceldatainMap(1);
		TravellersDetailsMethods tm=new TravellersDetailsMethods(driver, test);
		tm.addPassenger( Method1.get(0).get("FirstName"),Method1.get(0).get("LastName"));
//		tm.addPassenger( Method1.get(1).get("FirstName"),Method1.get(1).get("LastName"));
		tm.scrollUpTo();
		Method1=ExcelData.getexceldatainMap(0);
		tm.addEmail(Method1.get(0).get("Email"));
		tm.addMobileNo( Method1.get(0).get("Mobile No"));
		tm.continueBtn();
		
		tm.checkAssert();
	}
	
	
}
