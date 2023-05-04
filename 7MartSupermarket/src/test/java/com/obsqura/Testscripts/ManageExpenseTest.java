package com.obsqura.Testscripts;


import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;


import com.obsqura.Pages.ManageExpensePage;

import com.obsqura.Pages.SelectDashbordCategory;


import utilities.ExcelUtility;
import utilities.GeneralUtility;


public class ManageExpenseTest extends Base
{
	Login loginpagetest;
	ManageExpensePage manageexpensepage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyEditfunctionalityofExpenseCategory()
	{
		String alert=ExcelUtility.getString(9, 0,GeneralUtility.excelpath,"manageExpense");
		String title=ExcelUtility.getString(6, 0,GeneralUtility.excelpath,"manageExpense");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		manageexpensepage=new ManageExpensePage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpenseLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanagecategoryLink();
		manageexpensepage.clickOnEditButton();
		manageexpensepage.editvalueintitlefield(title).clickOnUpdateButton().clickOndeleteButtonUpdatepage();
		assertTrue(manageexpensepage.gettextofalertmessage().equals(alert),"manage expense details are not getting updated");	
	}
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifydeleteButtonfunctionality()
	{
		String deletealert=ExcelUtility.getString(4, 0,GeneralUtility.excelpath,"manageExpense");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		manageexpensepage=new ManageExpensePage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpenseLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpense().clickOndeleteButton();
		manageexpensepage.gettextofalertmessage();
		assertTrue(manageexpensepage.gettextofalertmessage().equals(deletealert),"expense record is not deleted successfully");	
	}
	
	@Test(retryAnalyzer = commontests.Retry.class)
	public void verifyViewMoreButtonFunctionality()
	{
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		manageexpensepage=new ManageExpensePage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpenseLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,GeneralUtility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpense().clickOnviewmoreButton();
		assertTrue(manageexpensepage.gettextofcolumnviewmore(),"all details of expense is not displaying");	
	}
	
}
