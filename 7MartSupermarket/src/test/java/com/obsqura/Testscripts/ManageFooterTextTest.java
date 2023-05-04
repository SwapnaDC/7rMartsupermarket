package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.obsqura.Pages.ManageFooterTextPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.GeneralUtility;

public class ManageFooterTextTest extends Base
{
	Login loginpagetest;
	ManageFooterTextPage managefootertextpage;
	
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyEditFunctionalityOfManageFooterText()
	{
		String expectedalertmessage=ExcelUtility.getString(2, 1,GeneralUtility.excelpath,"footertextupdate");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managefootertextpage=new ManageFooterTextPage(driver);
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(1, 1, GeneralUtility.excelpath,"footertextupdate"));
		managefootertextpage.clickOnmanagecontentLink().clickOnmanagefootertextLink().clickOneditbutton();
		managefootertextpage.entervalueinAddressField(RandomDataUtility.fakerAddress())
		                    .entervalueinEmailField(RandomDataUtility.fakerEmailId())
		                    .entervalueinPhoneNoField(RandomDataUtility.fakerPhoneNo())
		                    .cliclOnupdateButton();
		assertEquals(expectedalertmessage,managefootertextpage.gettextofalertmessage(),"Manage footer text details are not getting updated");
		
	}

}
