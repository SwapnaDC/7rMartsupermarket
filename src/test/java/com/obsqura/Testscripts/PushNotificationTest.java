package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.PushNotificationPage;
import com.obsqura.Pages.SelectDashbordCategory;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.Utility;

public class PushNotificationTest extends Base
{
	Login loginpagetest;
	PushNotificationPage pushnotificationpage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void addPushNotificationadded() throws IOException
	{
		String title=ExcelUtility.getString(2, 0, utilities.Utility.excelpath,"pushnotification");
		String description=ExcelUtility.getString(3, 0,utilities.Utility.excelpath,"pushnotification");
		String alertmessage=ExcelUtility.getString(4, 0,utilities.Utility.excelpath,"pushnotification");
		pushnotificationpage=new 	PushNotificationPage(driver);
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory selectdashboardcategory=new SelectDashbordCategory(driver);
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"pushnotification"));
		pushnotificationpage.clickOnpushnotification().entertitleinthetitleField(title).enterdiscritioninthetitleField(description).cliclOnsendButton();
		assertEquals(alertmessage,pushnotificationpage.gettextofalertmessage(),"alert are not same");
	
	
	
	
	}
}
