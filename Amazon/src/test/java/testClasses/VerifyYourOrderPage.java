package testClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import amazonPom_pages.HomePage;
import amazonPom_pages.SignInPage;
import amazonPom_pages.YourOrderPage;
import base.Browser;

public class VerifyYourOrderPage {

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private YourOrderPage yourOrderPage;
	private SoftAssert soft;
	@Parameters("browser")
	@BeforeTest
	void launchBrowser(String expectedBrowser) 
	{
		System.out.println("expectedBrowser");
		
		driver = Browser.launchBrowser(expectedBrowser);
	}
	@BeforeClass
	void initianizePOM() 
	{		
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		yourOrderPage = new YourOrderPage(driver);		
	}
	
	@BeforeMethod
	void loginToApplication() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		soft = new SoftAssert();
		//homePage = new HomePage(driver);
		homePage.clickOnSignInButton();
		
		//signInPage = new SignInPage(driver);
		
		signInPage.enterEmailOrPhone("7350133346");
		signInPage.clickOnContinueButton();
		signInPage.EnterPassword("Ankush@7350");
		
		signInPage.clickOnSignInButton();
		
		Thread.sleep(30000);
		
	}
	
	@Test  (priority = 1, groups = {"Regression","Sanity"})
	void verifyYourOrderPage() 
	{
		//homePage = new HomePage(driver);
		homePage.clickOnYourOrder();
		
		//yourOrderPage = new YourOrderPage(driver);
		String expectedBuyButtonText = "Buy Again";
		String expectedNotShippedYetButtonText = "Not Yet Shipped";
		String expectedCancelledOrderButtonText = "Cancelled Orders";
		String expectedSearchOrderButtonText = "Search Orders";
		
		String actualdBuyButtonText = yourOrderPage.getBuyButtonText();
		String actualNotShippedYetButtonText = yourOrderPage.getNotShippedYetButton();
		String actualCancelledOrderButtonText = yourOrderPage.getCancelledOrderButton();
		String actualSearchOrderButtonText = yourOrderPage.getsearchOrderButton();
		
		
		Assert.assertEquals(actualdBuyButtonText, expectedBuyButtonText);
		
		soft.assertEquals(actualNotShippedYetButtonText, expectedNotShippedYetButtonText);
		soft.assertEquals(actualCancelledOrderButtonText, expectedCancelledOrderButtonText);
		soft.assertEquals(actualSearchOrderButtonText, expectedSearchOrderButtonText);
		
		soft.assertAll();	
	}
	@Test  (priority = 2, groups = {"Regression"})
	void vefiryYourOrderUrl() 
	{
		//homePage = new HomePage(driver);
		homePage.clickOnYourOrder();
		
		
		String expectedUrl = "https://www.amazon.in/";
		String actualUrl = "https://www.amazon.in/";
			
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterMethod
	void logoutFromApplication() 
	{
		//homePage = new HomePage(driver);
		
		homePage.clickOnSignOutButton();
	}
	
	@AfterClass
	void removePOM() 
	{
		homePage = null;
		signInPage = null;
		yourOrderPage = null;
		System.gc();//garbage collector		
	}
	@AfterTest
	void closedBrowser() 
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
