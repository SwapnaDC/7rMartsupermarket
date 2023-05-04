package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import com.obsqura.Pages.ManagePaymentPage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;


public class ManagePaymentTest extends Base 
{
	Login loginpagetest;
	ManagePaymentPage managepaymentpage;

	@Test(retryAnalyzer = commontests.Retry.class , groups = {"smoke", "regression"})
	public void verifyTheFunctionalityOfStatusButton()
	{
		String alert=ExcelUtility.getString(6, 0,GeneralUtility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managepayment"));
		managepaymentpage.clickOnStatus();
		assertEquals(alert,managepaymentpage.alertMessageofstatusSuccessfullychanged(),"status not changed");
			
	}
	
	@Test(retryAnalyzer = commontests.Retry.class , groups = {"smoke"})
	public void verifyUpdateButtonFunctionality()
	{
		String successfullyupdatedalert=ExcelUtility.getString(6, 1,GeneralUtility.excelpath,"managepayment");
		String title=ExcelUtility.getString(1, 1,GeneralUtility.excelpath,"managepayment");
		String limit=ExcelUtility.getNumeric(2, 1,GeneralUtility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managepayment"));
		managepaymentpage.clickOnEditButton();
		managepaymentpage.entervalueintitlefield(title).entervalueinlimitfield(limit);
		managepaymentpage.cliclOnupdateButton();
		assertEquals(successfullyupdatedalert,managepaymentpage.getalertmessageofupdatedalert(),"payment not updated");
			
	}
	@Test(retryAnalyzer = commontests.Retry.class , groups = {"regression"})
	public void verifyResetButtonfunctionality()
	{
		String debittext=ExcelUtility.getString(3, 1,GeneralUtility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managepayment"));
		managepaymentpage.clickOnresetButton();
		assertEquals(debittext,managepaymentpage.gettextdebit(),"payment page cannot directing to resetpage");
			
	}
	
	
	
	
	
}
