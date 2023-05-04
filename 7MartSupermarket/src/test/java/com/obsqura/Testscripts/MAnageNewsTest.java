package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageNewsPage;

import com.obsqura.Pages.SelectDashbordCategory;


import utilities.ExcelUtility;
import utilities.GeneralUtility;


public class MAnageNewsTest extends Base
{
	
	Login loginpagetest;
	ManageNewsPage managenewspage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyAddNewNewsFunctionality()
	
	{
		String news=ExcelUtility.getString(1, 0,GeneralUtility.excelpath,"managenews");
		String alertsuccess=ExcelUtility.getString(2, 0,GeneralUtility.excelpath,"managenews");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managenews"));
		managenewspage=new ManageNewsPage(driver);
		managenewspage.clickOnmanagecontentLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"managenews"));
		managenewspage.cliclOnmanageNewsLink().cliclOnNewButton().enterNewsinNewsField(news).cliclOnNewsSaveButton();
		assertEquals(alertsuccess,managenewspage.alertMessageOfNewsUpdated(),"News can't succssfully updated");
		
	
			
	}

}
