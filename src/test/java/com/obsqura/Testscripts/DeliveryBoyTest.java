package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.testng.annotations.Test;
import com.obsqura.Pages.DeliveryBoyPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.Utility;

public class DeliveryBoyTest extends Base
{
	Login loginpagetest;
	DeliveryBoyPage deliveryboypage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void addNewDeliveryboydetailstothDeleiveryBoyPage() throws IOException
	{
		String alert=ExcelUtility.getString(0, 1, utilities.Utility.excelpath,"deliveryboy"); 
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0, utilities.Utility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnNewButton();
		deliveryboypage.entervalueinNameField(FakerUtility.fakerEnterName()).entervalueinEmailField(FakerUtility.fakerEmailId()).entervalueinPhoneNoField(FakerUtility.fakerPhoneNo()).entervalueinAddressField(FakerUtility.fakerAddress()).entervalueinUsernameField(FakerUtility.fakerUsername()).entervalueinPasswordField(FakerUtility.fakerPassword());
		deliveryboypage.clickOnsaveButton();
		assertEquals(alert,deliveryboypage.getAlertMessageOfDeliveryBoy(),"cannot add new delivery boy details");
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void deleteDeliveryboydetailstothDeleiveryBoyPage() throws IOException
	{
		String alertdelete=ExcelUtility.getString(4, 0,utilities.Utility.excelpath,"deliveryboy"); 
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnDeleteButton();
		deliveryboypage.deletedeteils();
		assertEquals(alertdelete,deliveryboypage.deletedatasuccessfullyalertmessage(),"data cannot delete successfully");
		
	}
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void SearchDeliveryboydetailstothDeleiveryBoyPage() throws IOException
	{
		String name=ExcelUtility.getString(5, 0, utilities.Utility.excelpath,"deliveryboy"); 
		String email=ExcelUtility.getString(5, 1,utilities.Utility.excelpath,"deliveryboy"); 
		String ph=ExcelUtility.getString(5, 2,utilities.Utility.excelpath,"deliveryboy"); 
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnSearchButton().enterNameintheSearchField(name).enteremailintheSearchField(email).enterphonenointheSearchField(ph).cliclOnSearchButtontoGettheDetails();	
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyShowPasswordarrowisDisplayPassword() throws IOException
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclshowArrowAndGetPassword();	
		
	}
}
