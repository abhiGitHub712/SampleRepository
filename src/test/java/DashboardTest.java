import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Dashboard;
import Pages.LoginPage;

public class DashboardTest extends TestBase{
	Dashboard dash;
	LoginPage login;
	@BeforeMethod(groups = {"smoke"})
	public void setup() throws InterruptedException, IOException {
		initalization();
		dash = new Dashboard();
		login = new LoginPage();
		login.loginToPage();
	}

	@Test(groups = {"smoke"})
	public void startInvestingTest() throws InterruptedException, EncryptedDocumentException, IOException {
		dash.startInvesting();
	}
	
	
	
	@AfterMethod(groups = {"smoke"})
	public void exit() {
		driver.close();
	}
	
	
	
}
