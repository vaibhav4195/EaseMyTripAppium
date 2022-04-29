package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	

	static String add1=System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\MyOwnExtentReport"+BaseWithServer.timestamp+".html";
	public ExtentReportManager() {
		// TODO Auto-generated constructor stub
	}
	public static ExtentReports getReport() {
		if(extent==null) {
			extent=new ExtentReports();
			spark = new ExtentSparkReporter(add1);//it is an observer
			spark.config().setDocumentTitle("My_EaseMyTripProject_Extent_Report");
			spark.config().setReportName("Testing Methods from my Project");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("utf-8");
			extent.attachReporter(spark);
			extent.setSystemInfo("Company Name", "AQM Technelogies");
			extent.setSystemInfo("Project Name", "EaseMyTripAppium");
			extent.setSystemInfo("Tester Name", "Manish");
			extent.setSystemInfo("Tester Name", "Vaibhav");
		}
		return extent;
		
	}
}
