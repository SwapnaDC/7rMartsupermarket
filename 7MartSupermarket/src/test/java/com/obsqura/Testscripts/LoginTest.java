package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.Pages.LoginPage;

import utilities.ExcelUtility;
import utilities.GeneralUtility;



public class LoginTest extends Base
{
	LoginPage loginpage;
	
	@Test(dataProvider = "LoginProvider",priority = 3)
	public void verifyloginwithInvalidUserName(String username,String password)
	{
		String invalidalert=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();
		assertNotEquals(invalidalert,loginpage.alertmessage(),"Successfully login");		
	}
	public void verifyLoginWithInvalidPassword(String username,String password) throws IOException
	{
		String invalidalert=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();
		assertNotEquals(invalidalert,loginpage.alertmessage(),"Successfully login");
	}
	@DataProvider(name="LoginProvider")
    public Object[][] getDataFromDataprovider()
	{
		return new Object[][] 
    	{
            { "admin", "adminswapna" },
            { "adminswapna", "admin" }
        };
    }
	
	@Test(retryAnalyzer = commontests.Retry.class , priority = 1)
	public void verifyLoginwithValidUseranmeAndPassword()
	{
		String homepagetext=ExcelUtility.getString(0, 0, GeneralUtility.excelpath,"login");
		String username=ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"login");
		String password=ExcelUtility.getString(2, 1,GeneralUtility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();	
		assertEquals(homepagetext,loginpage.getTextHomePage(),"unable to login");
	}
	
	
	@Test(retryAnalyzer = commontests.Retry.class , priority = 2)
	@Parameters({"username","password"})
	public void verifyLoginpagewithInValidUsernameAndPassword(String username,String password)
	{
		String invalidalert=ExcelUtility.getString(4, 0, GeneralUtility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();	
		assertNotEquals(invalidalert,loginpage.alertmessage(),"Successfully login");	
	}	
}
