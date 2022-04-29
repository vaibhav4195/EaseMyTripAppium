package pageMethods;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.TravellersDetails;
import utilities.BasicMethods;

public class TravellersDetailsMethods {

	
	AppiumDriver<MobileElement> driver;
	TravellersDetails traveller;
	BasicMethods bm;
	public TravellersDetailsMethods(AppiumDriver<MobileElement> d,ExtentTest test) {

		this.driver=d;
		traveller = new TravellersDetails(driver);
		bm = new BasicMethods(test);
	}
	
//	public void passengerAddBtn() {
//		bm.clickElement(traveller.getAddAdultPassenger(), "Add Adult Btn");
//	}
	
	public void addPassenger(String firstname,String lastname) {
		bm.clickElement(traveller.getAddAdultPassenger(), "Add Adult Btn");
		bm.clickElement(traveller.getMrAbr(), "Mr Abbreviation ");
		bm.sendKeyElement(traveller.getFirstName(), firstname, "FirstName");
		bm.sendKeyElement(traveller.getLastName(), lastname, "LastName");
		bm.clickElement(traveller.getSaveTravellerBtn(), "Save Traveller");
	}
	
	public void scrollUpTo() {
		String scrollUpto = "I Accept T&C and Privacy Policy";	
		bm.scrollToText(scrollUpto);
	}
	
	public void addEmail(String email) {
		bm.sendKeyElement(traveller.getEmail(), email, "Adding Email");
	}

	public void addMobileNo(String mobileno) {
		bm.sendKeyElement(traveller.getMobileNumber(),  mobileno, "Mobile Number");	
	}
	
	public void continueBtn() {
		bm.clickElement(traveller.getCtnToPayBtn(), "Countinue Payent Btn");	
	}
	
	public void checkAssert() {
		//Checking Last Page/Payment Option Page
		
		WebDriverWait w=new WebDriverWait(driver,20);
		boolean t= w.until(ExpectedConditions.textToBePresentInElement(traveller.getPaymentOptionText(), "Payment Options"));
		Assert.assertEquals(t, true);
	}
	
}
