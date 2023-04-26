package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.Pages.DashboardCategory;
import com.obsqura.Pages.HomePagePage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.Utility;


public class HomePageTest extends Base 
{
	Login login;
	HomePagePage homepagepage;
	DashboardCategory dashboardcategory;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifymanageproductMoreInfoLinkisRedirectingToListProductPage() throws IOException 
	{
		String expectedListProductPagetext=ExcelUtility.getString(3, 0, Utility.excelpath,"home");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(1, 1, Utility.excelpath,"manageproduct"));
		homepagepage=new HomePagePage(driver);
		assertEquals(expectedListProductPagetext,homepagepage.gettextofListProduct(),"manage product cannot redirecting to list product");
		
	}
	@Test (groups = { "regression"})
	public void verifyTitleisDisplayedOnTheHomePage() throws IOException 
	{
		String expectedTitle=ExcelUtility.getString(1, 0, Utility.excelpath,"home");	
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		homepagepage=new HomePagePage(driver);
		assertEquals(expectedTitle,homepagepage.gettitle(),"title not displayed in the homepage");
	}
	
	

}
