package utilities;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Base {
	public static AppiumDriver<MobileElement> driver;

	
//	@BeforeTest
	public static AppiumDriver<MobileElement> openApp() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "Z54LCIIN7HCMOBGE");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.easemytrip.android");
		cap.setCapability("appActivity", "com.easemytrip.common.activity.HomeActivity");
		
		driver = new AppiumDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Application Started Successfully...");
		Thread.sleep(5000);
		return driver;
		
	}

}
