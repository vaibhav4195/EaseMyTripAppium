package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FlightReview;
import pages.HomePage;
import pages.Selecting_Flight;
import pages.TravellersDetails;
import utilities.BaseWithServer;
import utilities.BasicMethods;
import utilities.ExcelData;

public class BookFlightTicketTest extends BaseWithServer {
	BasicMethods bm;
	List<Map<String, String>> Method1;
	@Test(priority = 0)
	public void homeTest() throws InterruptedException, IOException {
		
		Method1=ExcelData.getexceldatainMap(0);
		
		//Start a server
		service = startServer();
		//Open app capabilities and initialize driver
		openApp1();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home =new HomePage(driver);
		bm=new BasicMethods(test);
		bm.clickElement(home.getClickMenus(), "Menu Btn");

		bm.clickElement(home.getSelectFlightLogo(), "Flight Logo");

		bm.clickElement(home.getOneWayTicket(), "OneWay Btn");

		bm.clickElement(home.getSourceCityBtn(), "Source City Btn");

		Thread.sleep(3000);
		bm.sendKeyElement(home.getSourceCityName(), Method1.get(0).get("Source City"), "Source City Name");

		bm.clickElement(home.getSelectCity(), "Selecting Source City");
		
		bm.clickElement(home.getDestCityBtn(), "Destination City Btn");
		bm.sendKeyElement(home.getSelectdestCityName(), Method1.get(0).get("Destination City"),"Destination City Name");
		bm.clickElement(home.getSelectdestCity(), "Selecting Destination City");
		
		//selecting Date
		bm.clickElement(home.getSelectDepDateBtn(), "Date Btn");
		bm.scrollToText("July 2022");
		bm.clickElement(home.getSelectDepDate(), home.getSelectDepDate().getText());
		
		bm.clickElement(home.getPassangerCountBtn(), "Passanger Btn");
		bm.clickElement(home.getNoOfPassanger(), "No of Passangers");
		bm.clickElement(home.getPassangerDoneBtn(), "Passanger Done Btn");
		
		bm.clickElement(home.getClassBtn(), "Class Btn");
		bm.clickElement(home.getSelectClass(), "Selecting Class");
		bm.clickElement(home.getSearchFlightBtn(), "Seaeching Flight ");			
	}
	
	@Test(priority = 1)
	public void selectingFlight() {
		Selecting_Flight select=new Selecting_Flight(driver);	
		bm.clickElement(select.getFlightOneSelected(), "First Flight Selected..");
		bm.clickElement(select.getPlanRadioBtn(), "Plan Selection");
		bm.clickElement(select.getBookNowBtn(), "Book Now Btn");	
	}
	
	@Test(priority = 2)
	public void flightReview() {
		FlightReview review = new FlightReview(driver);
		bm.clickElement(review.getContinueBookingBtn(), "Continue Booking Btn");
		bm.clickElement(review.getInsureRadioBtn(), "Not Insured Btn");
		bm.clickElement(review.getContinueBookingBtn(), "Continue Booking Btn");
		
	}
	
	@Test(priority = 3)
	public void travellerDetails() throws IOException {
		Method1=ExcelData.getexceldatainMap(1);
		TravellersDetails traveller = new TravellersDetails(driver);
		//Adding Travelers Details
		bm.clickElement(traveller.getAddAdultPassenger(), "Add Adult Btn");
		bm.clickElement(traveller.getMrAbr(), "Mr Abbreviation ");
		bm.sendKeyElement(traveller.getFirstName(), Method1.get(0).get("FirstName"), "FirstName");
		bm.sendKeyElement(traveller.getLastName(), Method1.get(0).get("LastName"), "LastName");
		bm.clickElement(traveller.getSaveTravellerBtn(), "Save Traveller");
		
		bm.clickElement(traveller.getAddAdultPassenger(), "Add Adult Btn");
		bm.clickElement(traveller.getMrAbr(), "Mr Abbreviation ");
		bm.sendKeyElement(traveller.getFirstName(),  Method1.get(1).get("FirstName"), "FirstName");
		bm.sendKeyElement(traveller.getLastName(), Method1.get(1).get("LastName"), "LastName");
		bm.clickElement(traveller.getSaveTravellerBtn(), "Save Traveller");
		
		String scrollUpto = "I Accept T&C and Privacy Policy";	
		bm.scrollToText(scrollUpto);
		Method1=ExcelData.getexceldatainMap(0);
		bm.sendKeyElement(traveller.getEmail(), Method1.get(0).get("Email"), "Adding Email");
		bm.sendKeyElement(traveller.getMobileNumber(),  Method1.get(0).get("Mobile No"), "Mobile Number");
		bm.clickElement(traveller.getCtnToPayBtn(), "Countinue Payent Btn");
		
		//Checking Last Page/Payment Option Page
		Assert.assertEquals(traveller.getPaymentOptionText().isDisplayed(), false);
	
		service.stop();
	}
	
	
}
