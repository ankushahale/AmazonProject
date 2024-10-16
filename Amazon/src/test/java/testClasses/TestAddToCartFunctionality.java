package testClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
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

import amazonPom_pages.CartDetailsPage;
import amazonPom_pages.HomePage;
import amazonPom_pages.ProductDetailsPage;
import amazonPom_pages.SelectItemPage;
import amazonPom_pages.SignInPage;
import base.Browser;
import popUp.RecommedendAccessoriesPage;
import utils.Utility;

public class TestAddToCartFunctionality extends Browser {

	   private WebDriver driver;
	   private HomePage homePage;
	   private SignInPage signInPage;
	   private SelectItemPage selectItemPage;
	   private ProductDetailsPage productDetailsPage;
	   private RecommedendAccessoriesPage recommedendAccessoriesPage;
	   private CartDetailsPage cartDetailsPage;
	   private SoftAssert soft;
	   private List<String> browserAddress;
	
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
		   selectItemPage = new SelectItemPage(driver);
		   productDetailsPage = new ProductDetailsPage(driver);
		   recommedendAccessoriesPage = new RecommedendAccessoriesPage(driver);
		   cartDetailsPage = new CartDetailsPage(driver);	   
	   }
	
		@BeforeMethod
		void loginToAmazon() throws EncryptedDocumentException, IOException 
		{
			driver.get("https://www.amazon.in/");
			
			//homePage = new HomePage(driver);
		    homePage.clickOnSignInButton();
			
		    //signInPage = new SignInPage(driver);
			
		    signInPage.enterEmailOrPhone(Utility.fetchDataFromExcelSheet("demo", 1, 1));	
			signInPage.clickOnContinueButton();
			signInPage.EnterPassword(Utility.fetchDataFromExcelSheet("demo", 1, 2));
			signInPage.clickOnSignInButton();
		    	
			soft = new SoftAssert();
		}
		
		@Test  (groups = {"Regression", "Sanity"})
		void verifyAddToCart() 
		{
			//homePage = new HomePage(driver);
			
		    homePage.enterProductName("iphone 14 128 gb");
			homePage.clickonSearchButton();
			
			//selectItemPage = new SelectItemPage(driver);
			selectItemPage.clickOnSelectItem();
			
			browserAddress = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserAddress.get(1));
			
			//productDetailsPage = new ProductDetailsPage(driver);
			
			String expectedProductName = productDetailsPage.getProductName();
			String expectedProductPrice = productDetailsPage.getProductPrice();
			String expectedProductColour = productDetailsPage.getProductColour();
			
			productDetailsPage.clickOnAddTOCart();
			
			//recommedendAccessoriesPage = new RecommedendAccessoriesPage(driver);
			recommedendAccessoriesPage.goToCartPage();
			
			//cartDetailsPage = new CartDetailsPage(driver);
			
			String actualProductName = cartDetailsPage.getFirstProductName();
			String actualProductPrice = "59,900";
			String actualProductColour = cartDetailsPage.getFirstProductColour();
			
			Assert.assertEquals(actualProductName, expectedProductName);
			soft.assertEquals(actualProductPrice, expectedProductPrice);
			soft.assertEquals(actualProductColour, expectedProductColour);
			
			soft.assertAll();		
		}
		@Test
		void verifyAddToCartMobile()
		{
            //homePage = new HomePage(driver);
			
		    homePage.enterProductName("mobile");
			homePage.clickonSearchButton();
			
			//selectItemPage = new SelectItemPage(driver);
			selectItemPage.clickOnSelectItem();
			
			browserAddress = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserAddress.get(1));
			
			//productDetailsPage = new ProductDetailsPage(driver);
			
			String expectedProductName = productDetailsPage.getProductName();
			String expectedProductPrice = productDetailsPage.getProductPrice();
			//String expectedProductColour = productDetailsPage.getProductColour();
			
			productDetailsPage.clickOnAddTOCart();
			
			//recommedendAccessoriesPage = new RecommedendAccessoriesPage(driver);
			recommedendAccessoriesPage.goToCartPage();
			
			//cartDetailsPage = new CartDetailsPage(driver);
			
			String actualProductName = cartDetailsPage.getFirstProductName();
			String actualProductPrice = cartDetailsPage.getFirstProductprice();
			//String actualProductColour = cartDetailsPage.getFirstProductColour();
			
			Assert.assertNotEquals(actualProductName, expectedProductName);
			soft.assertNotEquals(actualProductPrice, expectedProductPrice);
			//soft.assertEquals(actualProductColour, expectedProductColour);
			
			soft.assertAll();
		}
		
		@AfterMethod
		void signOutApplication()
		{
			 //homePage = new HomePage(driver);
			driver.close();
			driver.switchTo().window(browserAddress.get(0));
			homePage.clickOnSignOutButton();
		}
		
		@AfterClass
		void removePOM() 
		{
			 homePage = null;
			 signInPage = null;
			 selectItemPage = null;
			 productDetailsPage = null;;
			 recommedendAccessoriesPage = null;
			 cartDetailsPage = null;
			 System.gc();
		}
		@AfterTest
		void closedBrowser()
		{
			driver.quit();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
