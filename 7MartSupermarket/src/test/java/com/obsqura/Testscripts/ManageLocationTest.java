package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageLocationPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.GeneralUtility;


public class ManageLocationTest extends Base
{
	Login loginpagetest;
	ManageLocationPage managelocationpage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifysearchFunctionality()
	{
		String location=ExcelUtility.getString(3, 0,GeneralUtility.excelpath,"managelocation");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managelocation"));
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnSearchButton();
		managelocationpage.clickcountry().clickstate().enterlocation(location).SearchButtonclick();
		assertTrue(managelocationpage.gettextoftable(),"cannot found searched location");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyNewButtonfunctionalityOfManageLocationPage()
	{
		String deliverychager=ExcelUtility.getNumeric(1, 0,GeneralUtility.excelpath,"managelocation");
		String alert=ExcelUtility.getString(2, 0,GeneralUtility.excelpath,"managelocation");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managelocation"));
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnNewButton();
		managelocationpage.clickOnCountry().clickOnstate().entervalueinLocationField(RandomDataUtility.fakerplace()).entervalueinDeliverychagerField(deliverychager).clickOnsaveButton();
		assertEquals(alert,managelocationpage.getalertmessage(),"Failed to add location in manage location page");
	}
	
	

}
