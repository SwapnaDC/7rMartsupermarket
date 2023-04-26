package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.AdminUsersPage;
import com.obsqura.Pages.ManageLocationPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.Utility;

public class ManageLocationTest extends Base
{
	Login loginpagetest;
	ManageLocationPage managelocationpage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void addnewLocationTotheManageLocationPage() throws IOException
	{
		String deliverychager=ExcelUtility.getNumeric(1, 0,utilities.Utility.excelpath,"managelocation");
		String alert=ExcelUtility.getString(2, 0,utilities.Utility.excelpath,"managelocation");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"managelocation"));
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnNewButton();
		managelocationpage.clickOnCountry().clickOnstate().entervalueinLocationField(FakerUtility.fakerplace()).entervalueinDeliverychagerField(deliverychager).clickOnsaveButton();
		assertEquals(alert,managelocationpage.getalertmessage(),"location cannot added to the manage location page");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void searchLoactionfromtheListofLocations() throws IOException
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"managelocation"));
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickOnSearchButton();
		managelocationpage.clickcountry().clickstate().SearchButtonclick();
	}
	

}
