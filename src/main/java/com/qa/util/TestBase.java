package com.qa.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("E:\\Old\\InventoryCount_TDP_RP\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		
	}
	public static void initilizaton()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_chrome\\chromedriver_win32 (3)\\Chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void eleAvailability(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void eleClickable(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	

}
