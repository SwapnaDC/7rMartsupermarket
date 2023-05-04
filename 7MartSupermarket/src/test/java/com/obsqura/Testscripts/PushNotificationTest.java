package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.obsqura.Pages.PushNotificationPage;

import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;


public class PushNotificationTest extends Base
{
	Login loginpagetest;
	PushNotificationPage pushnotificationpage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyAddNewFunctionality() 
	{
		String title=ExcelUtility.getString(2, 0, GeneralUtility.excelpath,"pushnotification");
		String description=ExcelUtility.getString(3, 0,GeneralUtility.excelpath,"pushnotification");
		String alertmessage=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"pushnotification");
		pushnotificationpage=new PushNotificationPage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"pushnotification"));
		pushnotificationpage.clickOnpushnotification().entertitleinthetitleField(title).enterdiscritioninthetitleField(description).cliclOnsendButton();
		assertEquals(alertmessage,pushnotificationpage.gettextofalertmessage(),"alert are not same");
	
	
	
	
	}
}
