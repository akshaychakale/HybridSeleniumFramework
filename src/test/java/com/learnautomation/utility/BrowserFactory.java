package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver start_application(WebDriver driver,String browsername,String appURL){
		if (browsername.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");		
			 driver=new ChromeDriver();
			
		} else if(browsername.equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();

		}else if(browsername.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("Browser does not exist");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
public static void stop_application(WebDriver driver){
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		System.out.println("The Error message is "+e.getMessage());
	}
	driver.quit();
		
	}
}
