package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import pageMethods.FlightReviewMethods;
import pageMethods.HomePageMethods;
import pageMethods.SelectingFlightMethods;
import pageMethods.TravellersDetailsMethods;
import utilities.BaseWithServer;
import utilities.ExcelData;

public class BookTicketWithDataProvider extends BaseWithServer{
	
	List<Map<String, String>> Method1;
	@BeforeSuite
	public void startReport() {
		killAllNodes();
		service = startServer();
		extent=utilities.ExtentReportManager.getReport();
	}
	
	//	@BeforeMethod
	//	public void startSession(int i) throws Exception {
	//		Method1=ExcelData.getexceldatainMap(0);
	//		String testName = method.getName();
	//		System.out.println(testName);
	//		test=extent.createTest((method.getName()).toUpperCase());
	//		test=extent.createTest(Method1.get(i).get("TestCases").toUpperCase());
	//	}

	@BeforeTest(alwaysRun = true)
	public void startServerAndApp() throws InterruptedException, IOException {
		
		//Open app capabilities and initialize driver
		openApp1();
		extent=utilities.ExtentReportManager.getReport();
	}
	
	
	@Test(dataProvider = "data-provider")
	public void homePage(int i) throws IOException, InterruptedException {
//		service = startServer();
//		Open app capabilities and initialize driver
//		openApp1();
		Method1=ExcelData.getexceldatainMap(0);
		test=extent.createTest(Method1.get(i).get("TestCases").toUpperCase());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePageMethods hm = new HomePageMethods(driver, test);
		hm.flighLogoClick();
		hm.tripType();
		hm.sourceCity(Method1.get(i).get("Source City"));
		hm.destinationCity(Method1.get(i).get("Destination City"));
		hm.deparrtureDate();
		hm.passengerCount();
		hm.flightClass();
		hm.searchBtn();
		
		SelectingFlightMethods sm=new SelectingFlightMethods(driver, test);
		sm.selectingFirstFlight();
		
		FlightReviewMethods fm=new FlightReviewMethods(driver, test);
		fm.flightReview();
	
		
		TravellersDetailsMethods tm=new TravellersDetailsMethods(driver, test);
		
		tm.addPassenger( Method1.get(i).get("FirstName"),Method1.get(i).get("LastName"));
		
		tm.scrollUpTo();
		
		tm.addEmail(Method1.get(i).get("Email"));
		tm.addMobileNo( Method1.get(i).get("Mobile No"));
		tm.continueBtn();
		
		tm.checkAssert();
		driver.resetApp();
		
	}
//	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		extent.flush();
//		driver.resetApp();
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {

		if(result.getStatus() == ITestResult.FAILURE) {	
			String screenshotPath = takeScreenshotAtEndOfTest(result.getName());
			test.log(Status.FAIL, result.getName()+" Method is failed");
			//			test.log(Status.FAIL,"==="+ result.getTestContext());
			//			test.log(Status.FAIL, result.getThrowable().getMessage());
			test.fail(result.getThrowable().getLocalizedMessage());
			test.fail("Test Case failed, check screenshot below ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			//				test.fail("Test Case failed, check screenshot below "+test.addScreenCaptureFromPath(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+" Method is Passed");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName()+" Method is Skipped");
		}
	}
	
	
	@DataProvider (name = "data-provider")
	public Object[] testrunner123() throws IOException  {
		List<Map<String, String>> Method1;
		int count_yes=0;
		Method1 = ExcelData.getexceldatainMap(0);
		for(int i=0;i<Method1.size();i++) {
			if(Method1.get(i).get("Execute").equalsIgnoreCase("Yes")) 
			{
				count_yes++;
			}
		}

		Object[] newarr = new Object[count_yes];
		int u=0; 
		for(int i=0;i<Method1.size();i++) {

			if(Method1.get(i).get("Execute").equalsIgnoreCase("Yes")) 
			{

				newarr[u]=i;
				//					return new Object[] {Method1.get(i).get("Sr")};

			}
			else if(Method1.get(i).get("Execute").equalsIgnoreCase("No")) {
				continue;
			}
			u++;

		}
		Arrays.sort(newarr);
		return newarr;
	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		driver.closeApp();
		service.stop();
		
	}

	
}
