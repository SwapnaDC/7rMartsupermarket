package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManagePagePage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;


public class ManagePageTest extends Base 
{
	Login loginpagetest;
	ManagePagePage managepagepage;
	
	

	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyAddNewPageFunctionality()
	{
		String title=ExcelUtility.getString(5, 1,GeneralUtility.excelpath,"managepage");
		String description=ExcelUtility.getString(6, 1,GeneralUtility.excelpath,"managepage");
		String page=ExcelUtility.getString(7, 1,GeneralUtility.excelpath,"managepage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,GeneralUtility.excelpath,"managepage"));
		managepagepage.clickNewButton().entervalueintitleField(title).entervalueindiscriptionField(description).entervalueinpageField(page).clicksaveButton();
		assertFalse(managepagepage.getaddedelementFromthetable(),"new page added");
		
	} 
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyTheFunctionalityOfNewButtonColor()
	{
		String expectedcolor=ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"managepage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,GeneralUtility.excelpath,"managepage"));
		assertEquals(expectedcolor,managepagepage.getbackgroundColorofNewButton(),"new button color is not same");	
	} 
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifytheFunctionalityOfSearchButton()
	{
		String pagetitle=ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"searchbuttonpage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,GeneralUtility.excelpath,"managepage"));
		managepagepage.clickOnSearchButtontoGosearchPage().enterTitleinthetitlebox(pagetitle).clickOnSearchButtontofindPage();
		assertTrue(managepagepage.gettextofthetable(),"search element cannot found");
			
	}
	
	

}
