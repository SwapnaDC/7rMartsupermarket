package Automation.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.Pages.LoginPage;
import Utilities.ExcelUtility;

public class LoginTest extends Base
{
	LoginPage loginpage;
	@Test(dataProvider="LoginProvider")
	public void verifyLoginpage(String username,String password ) throws IOException
	{
		String expectedOutput=ExcelUtility.getString(0, 0, System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\TestData.xlsx","login");
		loginpage=new LoginPage(driver);
		loginpage.usernameText(username);
		loginpage.passwordText(password);
		assertFalse(loginpage.rememberCheckBoxisSelected(),"check box is selected");
		assertTrue(loginpage.loginbuttonIsEnabled(),"login button is not enabled");
		loginpage.loginbuttonclick();
		assertEquals(expectedOutput,loginpage.getTextHomePage(),"invalid username and password");
		
	}
	
	@DataProvider(name="LoginProvider")
    public Object[][] getDataFromDataprovider()
	{
		return new Object[][] 
    	{
            { "adminswpana", "admin" },
            { "admin", "adminswapna" },
            { "adminswapnaa", "adminswapnaaa" },
            { "admin", "admin"}
        };

    }
}
