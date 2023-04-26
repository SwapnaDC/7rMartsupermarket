package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageOfferCodePage;
import com.obsqura.Pages.ManageSliderPage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;

public class ManageSliderTest extends Base
{
	Login login;
	ManageSliderPage managesliderpage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void addnewSliderDetilstotheSliderPage() throws IOException 
	{
		String imagepath=ExcelUtility.getNumeric(1, 0, utilities.Utility.excelpath,"slider");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"slider"));
		managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickOnNewButton().clickOnChooseButton();
		//manageoffercodepage.clickOnsearchButton().entervalueintheoffercodefield(offer).clickOnsearch();
		//assertEquals(offer,manageoffercodepage.getvalueofthetable(),"searched offercode cannot found in the list");
		
	}

}
