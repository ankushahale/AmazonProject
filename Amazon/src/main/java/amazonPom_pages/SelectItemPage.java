package amazonPom_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectItemPage {

	@FindBy (xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[@data-cy='title-recipe']//h2//span")
	private WebElement selectFirstItem;
	
	
	public SelectItemPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickOnSelectItem() 
	{
		selectFirstItem.click();  
	}
	
	
	
	
	
	
	
	
	
	
}
