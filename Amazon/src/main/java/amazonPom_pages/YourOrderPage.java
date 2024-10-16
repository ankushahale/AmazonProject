package amazonPom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourOrderPage {

	@FindBy (xpath = "//ul[@role='tablist']//a[text()='Buy Again']")
	private WebElement buyButton;
	
	@FindBy (xpath = "//a[text()='Not Yet Shipped']")
	private WebElement notShippedYetButton;
	
	@FindBy (xpath = "//a[text()='Cancelled Orders']")
	private WebElement cancelledOrderButton;
	
	@FindBy (xpath = "(//span[@class='a-button-inner']//span)[1]")
	private WebElement searchOrderButton;
	private WebDriver driver;
	private Actions action;
	
	public YourOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		action = new Actions(driver);
		
	}
	
	public String getBuyButtonText() 
	{
		return buyButton.getText().trim();
	}
	
	public String getNotShippedYetButton() 
	{
		return notShippedYetButton.getText().trim();
	}
	
	public String getCancelledOrderButton() 
	{
		return cancelledOrderButton.getText().trim();
	}
	
	public String getsearchOrderButton() 
	{
		return searchOrderButton.getText().trim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
