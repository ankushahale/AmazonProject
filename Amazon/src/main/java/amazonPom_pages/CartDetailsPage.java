package amazonPom_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartDetailsPage {

	@FindBy (xpath = "//div[@data-item-index='1']//h4//span[@class='a-truncate-cut']")
	private WebElement firstProductName;
	
	@FindBy (xpath ="(//span[text()='Great Indian Festival'])[1]/parent::div/parent::div/parent::span/parent::li/following-sibling::div/div/div/span")
	private WebElement firstProductPrice;
	
	@FindBy (xpath = "//div[@class='sc-grid-content-tail']/li[4]/span/span[2]")
	private WebElement firstProductColour;
	private WebDriverWait wait;
	private WebDriver driver;
	
	public CartDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		wait = new WebDriverWait(driver , Duration.ofSeconds(20));
	}
	
	public String getFirstProductName() 
	{
		wait.until(ExpectedConditions.visibilityOf(firstProductName));
		return firstProductName.getText().trim();
	}
	
	public String getFirstProductprice() 
	{
		wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
		return firstProductPrice.getText().trim();
	}
	
	public String getFirstProductColour() 
	{
		wait.until(ExpectedConditions.visibilityOf(firstProductColour));
		return firstProductColour.getText().trim();
	}
	
	
}
