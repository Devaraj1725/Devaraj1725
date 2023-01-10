package utility;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constant {
	public WebDriver driver;
	public String path="./reports/report";
	Date d = new Date();
	String d1 = d.toString();
	String d2 = d1.replaceAll(":", "-");
	protected static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(path+d2+".html");
	protected static ExtentTest test;

	@BeforeMethod
	public void LaunchApplication() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(testurl);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("my reports");
		
	}
	
	public static void test(String testname, String Author, String testtype, String platform) {
		 test = extent.createTest(testname).assignAuthor(Author)
				.assignCategory(testtype).assignDevice(platform);
	}

	@AfterMethod
	public void CloseApplication(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			String path1 = GetScreenShot.GetPhoto(driver);
			test.addScreenCaptureFromPath(path1, "screen shot of failed step");
			test.fail("test failed");
		}
		extent.attachReporter(spark);
		extent.flush();
		driver.close();
	}
}
