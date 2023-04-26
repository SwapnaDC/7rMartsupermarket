package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.AdminUsersPage;

import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.Utility;

public class AdminUsersTest extends Base
{
	Login loginpagetest;
	AdminUsersPage adminuserspage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void addNewAdminUsersTotheAdminPage() throws IOException
	{
		String alert=ExcelUtility.getString(1, 0,utilities.Utility.excelpath,"adminuserpage");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.cliclOnnewButton().entervalueinUsernameField(FakerUtility.fakerUsername()).entervalueinPasswordField(FakerUtility.fakerPassword()).clickOnUsertype().cliclOnsaveButton();
		assertEquals(alert,adminuserspage.getalertmessage(),"New user cannot added in the users list");
	
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void deleteUsersFromtheAdminList() throws IOException
	{
		String alert=ExcelUtility.getString(2, 0, utilities.Utility.excelpath,"adminuserpage");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0, utilities.Utility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOndeleteButton();
		assertEquals(alert,adminuserspage.getalertmessage(),"user can't deleted from the users list");
	
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifycancelFunctionalityofThePopUPWhileclickingtheDeleteButton() throws IOException
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOncancelButton();
		
	
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyuserStatusChangeWhileClickingLockbutton() throws IOException
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"adminuserpage"));
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnlockButton();
		System.out.println(adminuserspage.getalertmessage());
		
	
	}
}
