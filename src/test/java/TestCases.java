import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class TestCases  extends TestBase {
	LoginPage login;
	
 @BeforeMethod(groups = {"Regression","Sanity"})
 public void setup() throws IOException {
	 initalization();
	 login= new LoginPage();
	 
			 
 }
 
 @Test(groups = {"Regression"})
 public void verifyTitleTest() {
	 String title = login.verifyTitle();
	 Assert.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
 }
 
 @Test(groups = {"Regression"})
 public void verifykitLogoTest() {
	 
	 boolean value =login.verifykitLogo();
	 Assert.assertEquals(value, true);
	 
 }
 
 @Test(groups = {"Sanity"})
 public void verifyzerodhaLogo() {
	boolean zerodhaLogo= login.verifyzerodhaLogo();
	Assert.assertEquals(zerodhaLogo, true);
 }
 @Test(groups = {"Sanity"})
 public void loginToPageTest() throws InterruptedException, IOException {
	 String nickname = login.loginToPage();
	 Assert.assertEquals(nickname, "Abhijeet");
 }
 
 @AfterMethod(groups = {"Regression","Sanity"})
  	public void exit() throws InterruptedException {
	 driver.quit();
 }
 
 
 
 
 
 
	
	
	
	

}
