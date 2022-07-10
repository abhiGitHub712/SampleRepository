package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class Util1 extends TestBase  {
	public static void screenshot(String name) throws IOException {
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\abhijeet\\eclipse-workspace\\26FebFramework\\Screenshots\\"+name+".jpeg");
	org.openqa.selenium.io.FileHandler.copy(source, dest);
	}

}
