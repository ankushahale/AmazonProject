package amazonPom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {

	@FindBy (xpath = "//input[@name='customerName']")
	private WebElement fullName;
	
	@FindBy (xpath = "//input[@name='email']")
	private WebElement  mobNumber;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement  password;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement  verifyMobNumber;
	
	
	public CreateNewAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFullName() 
	{
		fullName.sendKeys("Ankush Ahale");
	}
	
	public void enterMobNumber() 
	{
		mobNumber.sendKeys("7350133346");
	}
	
	public void enterPassword() 
	{
		password.sendKeys("Ankush@123");
	}
	
	public void clickOnVerifyMobNumberButton() 
	{
		verifyMobNumber.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
