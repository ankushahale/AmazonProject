package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver launchChromeBrowser() 
	{
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver launchFirefoxBrowser() 
	{
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver launchEdgeBrowser() 
	{
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	public static WebDriver launchBrowser(String targetBrowser) 
	{
		WebDriver driver = null;
		
		if(targetBrowser.equals("Chrome"))
		{
			driver = launchChromeBrowser();
		}
		
		if(targetBrowser.equals("Firefox"))
		{
			driver = launchFirefoxBrowser();
		}
		
		if(targetBrowser.equals("Edge")) 
		{
			driver = launchEdgeBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
