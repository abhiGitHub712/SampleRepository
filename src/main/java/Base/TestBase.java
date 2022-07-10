package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.google.common.base.MoreObjects.ToStringHelper;

public class TestBase {
		public static WebDriver driver;
		
		public String readPropertyFile(String value) throws IOException {
			Properties properties= new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\abhijeet\\eclipse-workspace\\26FebFramework\\src\\main\\java\\Config\\Config.properties");
			
			properties.load(file);
			return properties.getProperty(value);
					
		}
		public void initalization() throws IOException {
			String browserName = readPropertyFile("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://kite.zerodha.com/");
			driver.manage().window().maximize();
			driver.get(readPropertyFile("url"));
			}
			else if (browserName.equalsIgnoreCase("firefox")) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--disable-notifictions");
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver(fo);
				driver.manage().window().maximize();
				driver.get(readPropertyFile("url"));
				
			
				
			}
			
		}
		public String readExcelSheet(int rowNum, int colNum) throws EncryptedDocumentException, IOException {
			FileInputStream file = new FileInputStream("C:\\Users\\abhijeet\\eclipse-workspace\\26FebFramework\\ExcelSheet\\CreateGTT_Credenial.xlsx");
			Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
			String value= excel.getRow(rowNum).getCell(colNum).getStringCellValue();
			return value;
		}
		
		
}
