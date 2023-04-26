package com.obsqura.Testscripts;



import java.io.IOException;

import org.testng.annotations.Test;


import com.obsqura.Pages.ManageExpensePage;

import com.obsqura.Pages.SelectDashbordCategory;


import utilities.ExcelUtility;


public class ManageExpenseTest extends Base
{
	Login loginpagetest;
	ManageExpensePage manageexpensepage;
	@Test(retryAnalyzer = commontests.Retry.class)
	public void clickViewMoreArrowAndtocheckdisplaytheDetails()  throws IOException 
	{
		
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		manageexpensepage=new ManageExpensePage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpenseLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpense().clickOnshowmorearrow();
		
	}
	@Test(retryAnalyzer = commontests.Retry.class)
	public void clickdeletebuttontoVerifyelementisdeleted()  throws IOException 
	{
		//String text=ExcelUtility.getNumeric(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"manageExpense");
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		manageexpensepage=new ManageExpensePage(driver);
		SelectDashbordCategory adshboardcategory=new SelectDashbordCategory(driver);
		adshboardcategory.selectDashboardDropdownListCategoryLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpenseLink();
		adshboardcategory.selectdashboardMenuLink(ExcelUtility.getString(0, 0,utilities.Utility.excelpath,"manageExpense"));
		manageexpensepage.clickOnmanageexpense().clickOndeleteButton();
		
		
	}
}
