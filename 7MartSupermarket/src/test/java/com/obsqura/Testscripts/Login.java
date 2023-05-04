package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;

import utilities.ExcelUtility;
import utilities.GeneralUtility;



public class Login extends Base
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	LoginPage loginpage;

	@Test
	public void verifyLoginwithValidUseranmeAndPassword()
	{
		String expectedhomepagetext=ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"login");
		String username=ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"login");
		String password=ExcelUtility.getString(2, 1,GeneralUtility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();	
		assertEquals(expectedhomepagetext,loginpage.getTextHomePage(),"unable to login");
	}
	

}
