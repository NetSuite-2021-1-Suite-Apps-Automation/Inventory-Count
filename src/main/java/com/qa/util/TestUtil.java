package com.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.AuthPage;
import com.qa.pages.LoginPage;
public class TestUtil extends TestBase{

	public static int IMPLICIT_WAIT=30;
	static LoginPage loginpage;
	static AuthPage authPage;
	public TestUtil()
	{
		super();
	}
	public static void explicitWait_visiblityOfElement(WebElement element,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void explicitWait_invisiblityOfElement(WebElement element,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void setUp() throws InterruptedException
	{
		initilizaton();
		loginpage=new LoginPage();
		authPage=new AuthPage();
		authPage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		authPage.choose_role();
		if(authPage.authquestion().equalsIgnoreCase("What was your childhood nickname?"))
		{
			authPage.enterAuthCode(prop.getProperty("auth1"));
		}
		else if(authPage.authquestion().equalsIgnoreCase("In what city did you meet your spouse/significant other?"))
		{
			authPage.enterAuthCode(prop.getProperty("auth2"));
		
		}
		else
		{
			authPage.enterAuthCode(prop.getProperty("auth3"));
		
		}
		//authPage.required_account("Administrator", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
	
	
	}
}