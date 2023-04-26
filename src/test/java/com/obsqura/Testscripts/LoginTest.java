package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.Pages.LoginPage;

import utilities.ExcelUtility;
import utilities.Utility;


public class LoginTest extends Base
{
	LoginPage loginpage;
	
	@Test(dataProvider = "LoginProvider")
	public void verifyloginwithInvalidUserName(String username,String password) throws IOException
	{
		String expectedalert=ExcelUtility.getString(4, 0, Utility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();
		assertNotEquals(expectedalert,loginpage.alertmessage(),"Successfully login");		
	}
	public void verifyLoginWithInvalidPassword(String username,String password) throws IOException
	{
		String expectedalert=ExcelUtility.getString(4, 0,Utility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();
		assertNotEquals(expectedalert,loginpage.alertmessage(),"Successfully login");
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
	@Test(groups = "smoke")
	public void verifyLoginwithValidUseranmeAndPassword() throws IOException
	{
		String expectedhomepagetext=ExcelUtility.getString(0, 0, Utility.excelpath,"login");
		String username=ExcelUtility.getString(1, 1, Utility.excelpath,"login");
		String password=ExcelUtility.getString(2, 1,Utility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();	
		System.out.println(loginpage.getTextHomePage());
		assertEquals(expectedhomepagetext,loginpage.getTextHomePage(),"unable to login");
	}
	@Test(groups = "regression")
	@Parameters({"username","password"})
	public void verifyLoginpagewithInValidUsernameAndPassword(@Optional("adminswapna")String username,@Optional("adminswapna")String password) throws IOException
	{
		String expectedalert=ExcelUtility.getString(4, 0, Utility.excelpath,"login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username).passwordText(password).loginbuttonclick();	
		assertNotEquals(expectedalert,loginpage.alertmessage(),"Successfully login");	
	}	
}
