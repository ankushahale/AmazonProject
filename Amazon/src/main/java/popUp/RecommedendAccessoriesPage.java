package popUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecommedendAccessoriesPage {

	@FindBy (xpath ="//span[@id='attach-sidesheet-view-cart-button']//input")
	private WebElement cartButton;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public RecommedendAccessoriesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				
	}
	
	public void goToCartPage() 
	{
		wait.until(ExpectedConditions.visibilityOf(cartButton));
		cartButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
