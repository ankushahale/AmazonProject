package amazonPom_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy (xpath = "//a[@id='nav-link-accountList']")
	private WebElement accountList;
	
	@FindBy (xpath = "//span[text()='Sign in']")
	private WebElement signIn;
	
	
	@FindBy (xpath = "//span[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	@FindBy (xpath = "//div[@id='nav-flyout-searchAjax']//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]")
	private WebElement secondSuggesstionOption;
	
	@FindBy (xpath = "//a[@id='nav_prefetch_yourorders']/span[text()='Your Orders']")
	private WebElement yourOrder;
	
	@FindBy (xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement signInText;
	
	private Actions action;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver , Duration.ofSeconds(20));
	}
	
	
	public void clickOnAccountList() 
	{
		accountList.click();
	}
	
	public void clickOnSignInButton() 
	{
		action.moveToElement(accountList).moveToElement(signIn).click().build().perform();
	}
	
	public void clickOnSignOutButton() 
	{
		action.moveToElement(accountList).moveToElement(signOut).click().build().perform();
	}
	
	public void enterProductName(String itemName) 
	{
		searchTextBox.sendKeys(itemName);
	}
	
	public void clickonSearchButton() 
	{
		searchButton.click();
	}
	
	public void clickOnSecondSuggesstionOption() 
	{
		secondSuggesstionOption.click();
	}
	
	public void clickOnYourOrder()
	{
		
		action.moveToElement(accountList).moveToElement(yourOrder).click().build().perform();
	}
	
	public String getSignInText()
	{
		return signInText.getText().trim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
