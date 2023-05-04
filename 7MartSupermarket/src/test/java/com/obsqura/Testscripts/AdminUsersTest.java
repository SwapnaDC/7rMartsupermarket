package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.obsqura.Pages.AdminUsersPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.GeneralUtility;


public class AdminUsersTest extends Base
{
	Login loginpagetest;
	AdminUsersPage adminuserspage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyNewButtonFunctionality()
	{
		String alert=ExcelUtility.getString(1, 0,GeneralUtility.excelpath,"adminuserpage");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.cliclOnnewButton().entervalueinUsernameField(RandomDataUtility.fakerUsername())
		                                 .entervalueinPasswordField(RandomDataUtility.fakerPassword())
		                                 .clickOnUsertype().cliclOnsaveButton();
		assertEquals(alert,adminuserspage.getalertmessage(),"New user cannot added in the users list");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyDeleteFunctionality()
	{
		String alert=ExcelUtility.getString(2, 0, GeneralUtility.excelpath,"adminuserpage");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0, GeneralUtility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOndeleteButton();
		assertEquals(alert,adminuserspage.getalertmessage(),"user can't deleted from the users list");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyCancelButtonFunctionalityOfPopUpWindow()
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOncancelButton();
		assertTrue(adminuserspage.displaySamePage(),"user can't cancel the deletePop up window");
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyStatusChangedFunctionality()
	{
		String statuschangealert=ExcelUtility.getString(3, 0, GeneralUtility.excelpath,"adminuserpage");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnlockButton();
		assertEquals(statuschangealert,adminuserspage.getstatuschangealertmessage(),"status is not  changing");
		
	}
}
