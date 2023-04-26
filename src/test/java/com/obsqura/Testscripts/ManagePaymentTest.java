package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.obsqura.Pages.DashboardCategory;
import com.obsqura.Pages.ManagePaymentPage;
import com.obsqura.Pages.SelectDashbordCategory;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.Utility;

public class ManagePaymentTest extends Base 
{
	Login loginpagetest;
	ManagePaymentPage managepaymentpage;

	@Test(retryAnalyzer = commontests.Retry.class)
	public void managePaymentinformationStatusisChangedActiveAndInactive() throws IOException
	{
		String alert=ExcelUtility.getString(6, 0,Utility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,Utility.excelpath,"managepayment"));
		managepaymentpage.clickOnStatus();
		assertEquals(alert,managepaymentpage.alertMessageofstatusSuccessfullychanged(),"status not changed");
			
	}
	
	@Test
	public void managePaymentinformationEditedtothePaymentPage() throws IOException
	{
		String successfullyupdatedalert=ExcelUtility.getString(6, 1,Utility.excelpath,"managepayment");
		String title=ExcelUtility.getString(1, 1,Utility.excelpath,"managepayment");
		String limit=ExcelUtility.getNumeric(2, 1,Utility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,Utility.excelpath,"managepayment"));
		managepaymentpage.clickOnEditButton();
		managepaymentpage.entervalueintitlefield(title).entervalueinlimitfield(limit);
		managepaymentpage.cliclOnupdateButton();
		assertEquals(successfullyupdatedalert,managepaymentpage.getalertmessageofupdatedalert(),"payment not updated");
			
	}
	@Test
	public void managePaymentresetButtonverify() throws IOException
	{
		String debittext=ExcelUtility.getString(0, 2,Utility.excelpath,"managepayment");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managepaymentpage=new ManagePaymentPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0, Utility.excelpath,"managepayment"));
		managepaymentpage.clickOnresetButton();
		assertEquals(debittext,managepaymentpage.gettextdebit(),"payment page cannot directing to resetpage");
			
	}
	
	
	
	
	
}
