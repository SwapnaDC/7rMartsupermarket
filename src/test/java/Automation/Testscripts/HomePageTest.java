package Automation.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Automation.Pages.HomePagePage;

public class HomePageTest extends Base 
{
	HomePagePage homepagepage;
	
	@Test(groups = {"smoke"})
	@Parameters({"username","password"})
	public void verifymanageproductClick(String username,String password) 
	{
		homepagepage=new HomePagePage(driver);
		homepagepage.usernameText(username);
		homepagepage.passwordText(password);
		homepagepage.loginbuttonclick();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/home");
		homepagepage.clickManageProduct();
	}
	@Test (groups = { "smoke"})
	@Parameters({"username","password","title"})
	public void verifyprojectTitle(String username,String password,String title) 
	{
		String expectedtitle="7rmart supermarket"; 
		homepagepage=new HomePagePage(driver);
		homepagepage.usernameText(username);
		homepagepage.passwordText(password);
		homepagepage.loginbuttonclick();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/home");
		homepagepage.gettitle();
		assertEquals(expectedtitle,homepagepage.gettitle(),"title are not same");
	}
	@Test (groups = { "smoke", "regression" })
	@Parameters({"username","password","color"})
	public void verifybackgroundColorofDashBoard(String username,String password,String color)
	{
		String expectedColor="rgba(52, 58, 64, 1)";
		homepagepage=new HomePagePage(driver);
		homepagepage.usernameText(username);
		homepagepage.passwordText(password);
		homepagepage.loginbuttonclick();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/home");
		homepagepage.getbackgroundColorofDashBoard();
		assertEquals(expectedColor,homepagepage.getbackgroundColorofDashBoard(),"background color are not equal");
		
	}
	
	
	

}
