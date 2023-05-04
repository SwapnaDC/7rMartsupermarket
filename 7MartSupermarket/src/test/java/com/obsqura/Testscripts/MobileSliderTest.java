package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import com.obsqura.Pages.MobileSliderPage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class MobileSliderTest extends Base
{
	Login loginpagetest;
	MobileSliderPage mobilesliderpage;
	

	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyDeleteFucntionality() 
	{
		String alert=ExcelUtility.getString(1, 0,GeneralUtility.excelpath,"manageslider");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		mobilesliderpage=new MobileSliderPage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageslider"));
		mobilesliderpage.cliclOnDeleteButton();
		assertEquals(alert,mobilesliderpage.getDeletedalertMessage(),"mobile slider cannot delete");
			
	}
}
