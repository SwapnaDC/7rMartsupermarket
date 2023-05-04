package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.obsqura.Pages.ManageSliderPage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class ManageSliderTest extends Base
{
	Login login;
	ManageSliderPage managesliderpage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyFuntionalityOfUploadbutton() 
	{
		String alert=ExcelUtility.getString(2, 0, GeneralUtility.excelpath,"slider");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"slider"));
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickOnNewButton().clickOnChooseButton().enterlink().clickOnsaveButton();
		assertEquals(alert,managesliderpage.getalertmessage(),"slider cannot added successfully");
		
		
	}

}
