package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.HomePagePage;
import com.obsqura.Pages.ManageFooterTextPage;
import com.obsqura.Pages.SelectDashbordCategory;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base
{
	Login loginpagetest;
	ManageFooterTextPage managefootertextpage;
	
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void editAndUpdatemanagefootertext() throws IOException 
	{
		String expectedalertmessage=ExcelUtility.getString(2, 1, utilities.Utility.excelpath,"footertextupdate");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		managefootertextpage=new ManageFooterTextPage(driver);
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(1, 1, utilities.Utility.excelpath,"footertextupdate"));
		managefootertextpage.clickOnmanagecontentLink().clickOnmanagefootertextLink().clickOneditbutton();
		managefootertextpage.entervalueinAddressField(FakerUtility.fakerAddress()).entervalueinEmailField(FakerUtility.fakerEmailId()).entervalueinPhoneNoField(FakerUtility.fakerPhoneNo()).cliclOnupdateButton();
		assertEquals(expectedalertmessage,managefootertextpage.gettextofalertmessage(),"alert are not same");
		
	}

}
