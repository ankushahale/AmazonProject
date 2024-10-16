package amazonPom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	@FindBy (xpath = "//h1[@id='title']/span")
	private WebElement productName;
	
	@FindBy (xpath = "//div[@id='apex_desktop']/descendant::span[@class='a-price-whole']")
	private WebElement productPrice;
	
	@FindBy (xpath = "(//span[@class='selection'])[1]")
	private WebElement productColour;
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCartButton;
	
	@FindBy (xpath = "(//input[@id='buy-now-button'])")
	private WebElement buyButton;
	
	private WebDriver driver;
	
	
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public String getProductName() 
	{
		return productName.getText().trim();
	}
	
	public String getProductPrice() 
	{
		return productPrice.getText().trim();
	}
	
	public String getProductColour() 	
	{
		return productColour.getText().trim();
	}
	
	public void clickOnAddTOCart() 
	{
		addToCartButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
