package com.obsqura.Testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.obsqura.Pages.DeliveryBoyPage;
import com.obsqura.Pages.SelectHomeCategory;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;
import utilities.GeneralUtility;


public class DeliveryBoyTest extends Base
{
	Login loginpagetest;
	DeliveryBoyPage deliveryboypage;
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyNewButtonFunctionality()
	{
		String alert=ExcelUtility.getString(0, 1,GeneralUtility.excelpath,"deliveryboy"); 
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnNewButton();
		deliveryboypage.entervalueinNameField(RandomDataUtility.fakerEnterName())
					   .entervalueinEmailField(RandomDataUtility.fakerEmailId())
					   .entervalueinPhoneNoField(RandomDataUtility.fakerPhoneNo())
					   .entervalueinAddressField(RandomDataUtility.fakerAddress())
					   .entervalueinUsernameField(RandomDataUtility.fakerUsername())
					   .entervalueinPasswordField(RandomDataUtility.fakerPassword());
		deliveryboypage.clickOnsaveButton();
		assertEquals(alert,deliveryboypage.getAlertMessageOfDeliveryBoy(),"cannot add new delivery boy details");
	}
	
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyDeleteButtonFunctionality()
	{
		String alertdelete=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"deliveryboy"); 
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnDeleteButton();
		deliveryboypage.deletedeteils();
		assertEquals(alertdelete,deliveryboypage.deletedatasuccessfullyalertmessage(),"delivery boy details are not getting deleted successfully");
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyDeliveryboyPasswordIsDisplayed()
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectHomeCategory homecategory=new SelectHomeCategory(driver);
		homecategory.homepageCategoryRedirectionLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"deliveryboy"));
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.cliclOnArrow();
		assertTrue(deliveryboypage.showpassword(),"password is not displaying in dellivery boy page");
		
	}
	
	
	
}
