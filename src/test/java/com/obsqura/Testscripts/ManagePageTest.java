package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.obsqura.Pages.ManagePagePage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.Utility;

public class ManagePageTest extends Base 
{
	Login loginpagetest;
	ManagePagePage managepagepage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifymanageproductNewButtonColorisRed() throws IOException 
	{
		String expectedcolor=ExcelUtility.getString(1, 1,Utility.excelpath,"managepage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,Utility.excelpath,"managepage"));
		assertEquals(expectedcolor,managepagepage.getbackgroundColorofNewButton(),"new button color is not same");	
	} 
	@Test(retryAnalyzer = commontests.Retry.class)
	public void TocheckWhethersearchElementsisDisplayedintheListPage() throws IOException 
	{
		String pagetitle=ExcelUtility.getString(1, 1,Utility.excelpath,"searchbuttonpage");
		String expectednotfoundtext=ExcelUtility.getString(3, 1,Utility.excelpath,"searchbuttonpage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,Utility.excelpath,"managepage"));
		managepagepage.clickOnSearchButtontoGosearchPage().enterTitleinthetitlebox(pagetitle).clickOnSearchButtontofindPage();
		
		
		
	
			
	}
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifaddNewPageInthePageList() throws IOException 
	{
		String title=ExcelUtility.getString(5, 1,Utility.excelpath,"managepage");
		String description=ExcelUtility.getString(6, 1,Utility.excelpath,"managepage");
		String page=ExcelUtility.getString(7, 1,Utility.excelpath,"managepage");
		managepagepage=new ManagePagePage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(3, 1,Utility.excelpath,"managepage"));
		managepagepage.clickNewButton().entervalueintitleField(title).entervalueindiscriptionField(description).entervalueinpageField(page).clicksaveButton();
		
	} 
	
	

}
