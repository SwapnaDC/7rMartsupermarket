package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageContactPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.GeneralUtility;

public class ManageContactTest extends Base
{
	Login loginpagetest;
	ManageContactPage managecontactpage;
	
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyeditFunctionaliltyOfManageContactDetails()
	{
		String updatealertmessage=ExcelUtility.getString(1, 0,GeneralUtility.excelpath,"managecontact");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managecontactpage=new ManageContactPage(driver);
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0, GeneralUtility.excelpath,"managecontact"));
		managecontactpage.clickOnmanagecontentLink().clickOnmanagecontactLink()
						 .clickOneditbutton().entervalueinPhoneNoField(RandomDataUtility.fakerPhoneNo())
						 .entervalueinEmailField(RandomDataUtility.fakerEmailId())
						 .entervalueinAddressField(RandomDataUtility.fakerAddress()).clickOnUpdatebutton();
		assertEquals(updatealertmessage,managecontactpage.successalertmessage(),"manage contact details are not getting updated");
		
	}
}
