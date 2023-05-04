package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.Pages.ManageOrdersPage;

import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;

public class ManageOrdersTest extends Base
{
	Login login;
	ManageOrdersPage manageorderspage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyAssigningFunctionalityofDeliveryboyPage()
	{
		String alert=ExcelUtility.getString(1, 0, GeneralUtility.excelpath,"manageorders");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageorders"));
		manageorderspage=new ManageOrdersPage(driver);
		manageorderspage.ClickonAssignDeliveryboyButton().selectdeliveryBoyname().ClickonupdateButton();
		manageorderspage.getalertmessage();
		assertEquals(alert,manageorderspage.getalertmessage(),"deliveryboy cannot assigned successfully");
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyChangeDeliveryStatusFunctionality()
	{
		String errormessage=ExcelUtility.getString(2, 0, GeneralUtility.excelpath,"manageorders");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageorders"));
		manageorderspage=new ManageOrdersPage(driver);
		manageorderspage.Clickonstatusbutton().selectstatusofdelivery().ClickonDeliveryupdateButton();
		manageorderspage.geterrormessage();
		assertEquals(errormessage,manageorderspage.geterrormessage(),"cannot update delivery status");
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyViewDetailsFunctionalityOfDeliveryProcess() 
	{
		String orderdetailstext=ExcelUtility.getString(3, 0,GeneralUtility.excelpath,"manageorders");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageorders"));
		manageorderspage=new ManageOrdersPage(driver);
		manageorderspage.ClickonViewButton();
		assertTrue(manageorderspage.gettextoforderdetails().equals(orderdetailstext),"cannot display order details");
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyBackbuttonfunctionality()
	{
		String listordertext=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"manageorders");
		login=new Login(driver);
		login.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory homecategory=new SelectDashbordCategory(driver);
		homecategory.selectMoreinfoCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageorders"));
		manageorderspage=new ManageOrdersPage(driver);
		manageorderspage.ClickonViewButton().ClickonbackButton();
		assertEquals(listordertext,manageorderspage.gettextofListOrderpage(),"back button cannot redirecting to the list offer page");
	
		
	}
	
	

	}
