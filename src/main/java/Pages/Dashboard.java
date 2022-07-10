package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Dashboard extends TestBase{
	
	
	@FindBy(xpath= "//span[text()='AS']") private WebElement avtarlable;
	@FindBy(xpath= "//h4[@class='username']") private WebElement usernameLable;
	@FindBy(xpath= "//div[@class='email']") private WebElement emailLable;
	@FindBy(xpath= "//button[text()='Start investing ']") private WebElement startInvestingBtn;
	@FindBy(xpath= "(//input[@icon='search'])[2]") private WebElement searchBar;
	@FindBy(xpath= "//li[@class='search-result-item selected']") private WebElement firstResult;
	@FindBy(xpath= "//button[text()='Create GTT ']") private WebElement createGTTBtn;
//	@FindBy(xpath= "//div[text()='Place']") private WebElement placeBtn;
	@FindBy(xpath = "//label[@for='radio-239']") private WebElement sellClickBtn;	
	@FindBy(xpath = "//input[@label='Trigger price']") private WebElement triggerPriceTextbox;
	@FindBy(xpath = "//input[@label='Qty.']") private WebElement qtyTexbox;
	@FindBy(xpath = "//input[@label='Price']") private WebElement priceTexbox;
	@FindBy(xpath = "//button[normalize-space(text())='Cancel']") private WebElement cancelBtn;
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	public String verifyusernameLable() {
		return usernameLable.getText();
	}
	public String verifyemailLable() {
		
		return emailLable.getText();
	}
	
	public void startInvesting() throws InterruptedException, EncryptedDocumentException, IOException {
		startInvestingBtn.click();
//		Thread.sleep(2000);
		searchBar.sendKeys(readExcelSheet(0, 0));
//		Thread.sleep(2000);
		firstResult.click();
//		Thread.sleep(2000);
		createGTTBtn.click();
//		Thread.sleep(2000);
//		sellClickBtn.click();
//		Thread.sleep(2000);
		triggerPriceTextbox.clear();
//		Thread.sleep(1000);
		triggerPriceTextbox.sendKeys(readExcelSheet(0, 1));
//		Thread.sleep(2000);
		qtyTexbox.clear();
//		Thread.sleep(1000);
		qtyTexbox.sendKeys(readExcelSheet(0, 2));
//		Thread.sleep(2000);
		priceTexbox.clear();
//		Thread.sleep(1000);
		priceTexbox.sendKeys(readExcelSheet(0, 3));
//		Thread.sleep(2000);
		cancelBtn.click();
//		Thread.sleep(3000);
		
	}
}
