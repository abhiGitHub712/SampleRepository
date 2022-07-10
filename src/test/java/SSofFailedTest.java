import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.Util1;

public class SSofFailedTest extends TestCases {
	LoginPage login ;
	@BeforeMethod
	public void setup() throws IOException {
		initalization();
		login= new LoginPage();
		
	}	
	@Test
	public void verifyKiteLogoTest1() {
		
		login.verifykitLogo();
	}
	
	@AfterMethod
	public void exit(ITestResult it) throws IOException {
		if(ITestResult.FAILURE==it.getStatus()) {
			Util1.screenshot(it.getName());
		}
		driver.close();
	}
	

}
