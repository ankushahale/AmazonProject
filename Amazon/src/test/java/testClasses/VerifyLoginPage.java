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

import amazonPom_pages.HomePage;
import amazonPom_pages.SignInPage;
import base.Browser;

public class VerifyLoginPage extends Browser{

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	@Parameters("browser")
	
	@BeforeTest
	void openBrowser(String expectedBrowser) {
		
		System.out.println("expectedBrowser");
		
		driver = launchBrowser(expectedBrowser);
	}
	
	
	@BeforeClass
	void initializePOM() 
	{
		
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	}
	
	@BeforeMethod
	void openApplication()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1, groups = {"Regression"})
	void verifyLoginWithValidInput() throws InterruptedException  
	{
		//homePage = new HomePage(driver);
		homePage.clickOnSignInButton();
		
		//signInPage = new SignInPage(driver);
		signInPage.enterEmailOrPhone("7350133346");
		signInPage.clickOnContinueButton();
		
		signInPage.EnterPassword("Ankush@7350");
		signInPage.clickOnSignInButton();
		Thread.sleep(3000);
		String expectedSignInText = homePage.getSignInText();
		String actualSignInText = homePage.getSignInText();
		
		Assert.assertEquals(actualSignInText, expectedSignInText);
		
	}
	
	@Test (priority = 2)
	void vefiryWithInvalidLogin() throws InterruptedException
	{
		//homePage = new HomePage(driver);
		homePage.clickOnSignInButton();
		Thread.sleep(3000);
		//signInPage = new SignInPage(driver);
		signInPage.enterEmailOrPhone("7350133346");
		signInPage.clickOnContinueButton();
		
		signInPage.EnterPassword("Ankush@7350");
		signInPage.clickOnSignInButton();
		Thread.sleep(3000);
		String expectedSignInText = homePage.getSignInText();
		String actualSignInText = homePage.getSignInText();
		
		Assert.assertEquals(actualSignInText, expectedSignInText);
		
	}
	
	@AfterMethod
	void signOutApplication() 
	{
		//homePage = new HomePage(driver);
		homePage.clickOnSignOutButton();
	}
	
	@AfterClass
	void removePOM() 
	{
		homePage = null;
		signInPage = null;
		System.gc();
	}
	
	@AfterTest
	void closedBrowser() 
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
