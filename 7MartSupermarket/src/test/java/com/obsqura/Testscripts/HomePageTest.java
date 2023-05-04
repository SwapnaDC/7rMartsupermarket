package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.obsqura.Pages.DashboardCategory;
import com.obsqura.Pages.HomePagePage;
import com.obsqura.Pages.SelectDashbordCategory;


import utilities.ExcelUtility;
import utilities.GeneralUtility;



public class HomePageTest extends Base 
{
	Login login;
	HomePagePage homepagepage;
	DashboardCategory dashboardcategory;
	
	
	@Test (groups = { "regression"})
	public void verifyTitleisDisplayedOnTheHomePage()
	{
		String expectedTitle=ExcelUtility.getString(1, 0,GeneralUtility.excelpath,"home");	
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		homepagepage=new HomePagePage(driver);
		assertEquals(expectedTitle,homepagepage.gettitle(),"title not displayed in the homepage");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyManageProductMoreInfoLinkisRedirectingToListProductPage()
	{
		String expectedListProductPagetext=ExcelUtility.getString(3, 0, GeneralUtility.excelpath,"home");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"manageproduct"));
		homepagepage=new HomePagePage(driver);
		assertEquals(expectedListProductPagetext,homepagepage.gettextofListProduct(),"manage product cannot redirecting to list product");
	}
	
	
	

}
