package amazonPom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy (xpath = "//input[@name='email']")
	private WebElement EmailOrPhone;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signinButton;
	
	@FindBy (xpath = "//a[@id='createAccountSubmit']")
	private WebElement createNewAccount; 
	
	public SignInPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmailOrPhone(String userid) 
	{
		EmailOrPhone.sendKeys(userid);
	}
	
	public void clickOnContinueButton() 
	{
		continueButton.click();
	}
	
	public void EnterPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	
	public void clickOnSignInButton() 
	{
		signinButton.click();
	}
	
	public void clickOnCreateNewAccountButton() 
	{
		createNewAccount.click();
	}
	
	
}
