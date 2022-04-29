package utilities;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseWithServer {
	public static AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


	//to start a server
	public static AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	//to check server is running or not
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If a control comes here, then it means that the port is in use
			isServerRunning = true;
		}finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	//To get Screenshot
	public static String takeScreenshotAtEndOfTest(String methodName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + methodName + timestamp + ".png";

		File finalDestination = new File(destination);
		FileHandler.copy(src, finalDestination);
		return destination;
	}

	//Applications desired capabilities and initialize mobile/appium driver
	public static AppiumDriver<MobileElement> openApp1() throws InterruptedException, IOException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", BasicMethods.configReader("platformName"));
		cap.setCapability("deviceName", BasicMethods.configReader("deviceName"));
		cap.setCapability("platformVersion",BasicMethods.configReader("platformVersion"));
		cap.setCapability("appPackage", BasicMethods.configReader("appPackage"));
		cap.setCapability("appActivity", BasicMethods.configReader("appActivity"));

		driver = new AppiumDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Application Started Successfully......");
		Thread.sleep(3000);
		return driver;

	}

	
//	@BeforeTest(alwaysRun = true)
//	public void startServerAndApp() throws InterruptedException, IOException {
//		
//		//Open app capabilities and initialize driver
//		openApp1();
//	}
//	

	//To kill server if any server is running on port
	public void killAllNodes() {
		//to kill a appium server if it already running
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(3000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
//	@AfterTest(alwaysRun = true)
//	public void afterTest() {
//		driver.resetApp();
//	}


	

}
