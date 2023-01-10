package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
	
public static String GetPhoto(WebDriver driver) throws IOException	{
	TakesScreenshot ts=(TakesScreenshot) driver;
	String photo="./photo/";
	Date d=new Date();
	String d1 = d.toString();
	String d2 = d1.replaceAll(":", "-");
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(photo+d2+".jpeg");
	FileUtils.copyFile(src, dst);
	
	String path = dst.getAbsolutePath();
	return path;
	
}
}
