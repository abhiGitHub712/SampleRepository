package Pages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kitLogo;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLog;
	
	@FindBy(xpath = "//input[@id='userid']") private WebElement usernameTextbox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextbox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitBtn;
	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath = "//span[@class='nickname']") private WebElement nickname;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	public String verifyTitle() {
		return driver.getTitle();
	}
	public boolean verifykitLogo() {
		
		return kitLogo.isDisplayed();
	}
	public boolean verifyzerodhaLogo() {
		
		return zerodhaLog.isDisplayed();
	}
	public String loginToPage() throws InterruptedException, IOException {
		usernameTextbox.sendKeys(readPropertyFile("userid"));
//		Thread.sleep(1000);
		passwordTextbox.sendKeys(readPropertyFile("password"));
//		Thread.sleep(1000);
		submitBtn.click();
//		Thread.sleep(2000);
		pin.sendKeys(readPropertyFile("pin"));
//		Thread.sleep(1000);
		continueBtn.click();
//		Thread.sleep(5000);
		return nickname.getText();
	}
	
	}

