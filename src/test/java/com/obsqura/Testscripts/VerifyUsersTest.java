package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageLocationPage;
import com.obsqura.Pages.SelectDashbordCategory;
import com.obsqura.Pages.SelectHomeCategory;
import com.obsqura.Pages.VerifyUsersPage;

import utilities.ExcelUtility;
import utilities.Utility;

public class VerifyUsersTest extends Base
{
	Login loginpagetest;
	VerifyUsersPage verifyuserspage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyverifyusersstatuschange() throws IOException
	{
		//String alertmessage=ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"verifyusers");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectdahsBoardCategoryLink(ExcelUtility.getString(0, 0, Utility.excelpath,"verifyusers"));
		verifyuserspage=new VerifyUsersPage(driver);
		verifyuserspage.clickOnstatusButton();
		System.out.println(verifyuserspage.gettextofresultnotfound());
		//assertEquals(alertmessage,verifyuserspage.gettextofalertmessage(),"status cannot change");
	}

}
