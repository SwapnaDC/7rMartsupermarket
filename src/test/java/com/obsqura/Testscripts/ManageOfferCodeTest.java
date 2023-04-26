package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.HomePagePage;
import com.obsqura.Pages.ManageOfferCodePage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base
{
	Login login;
	ManageOfferCodePage manageoffercodepage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void searchoffercodeandVeryfytheDetailsaredisplayedorNot() throws IOException 
	{
		String offer=ExcelUtility.getNumeric(1, 0, utilities.Utility.excelpath,"manageoffercode");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageoffercode"));
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnsearchButton().entervalueintheoffercodefield(offer).clickOnsearch();
		assertEquals(offer,manageoffercodepage.getvalueofthetable(),"searched offercode cannot found in the list");
		
	}
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void TocheckSearchedOffercodeisAciveorNot() throws IOException 
	{
		String offer=ExcelUtility.getNumeric(1, 0, utilities.Utility.excelpath,"manageoffercode");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageoffercode"));
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnsearchButton().entervalueintheoffercodefield(offer).clickOnsearch().clickonStatusbutton().getalertmessage();
	
		//assertEquals(offer,manageoffercodepage.getvalueofthetable(),"searched offercode cannot found in the list");
		
	}

}
