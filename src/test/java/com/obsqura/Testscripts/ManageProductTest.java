package com.obsqura.Testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.obsqura.Pages.ManageProductPage;
import com.obsqura.Pages.SelectDashbordCategory;

import utilities.ExcelUtility;
import utilities.Utility;

public class ManageProductTest extends Base
{
	Login loginpagetest;
	ManageProductPage manageproductpage;
	
	@Test
	public void verifyYesNoStatusColorischangedProductPage() throws IOException
	{
		//String expectedtext=ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"manageproduct");
		//String expectedproductinfotext=ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE,"manageproduct");
		
		loginpagetest=new Login(driver);
		loginpagetest.verifyLoginwithValidUseranmeAndPassword();
		SelectDashbordCategory selectdashboardcategory=new SelectDashbordCategory(driver);
		selectdashboardcategory.selectdashboardMenuLink(ExcelUtility.getString(1, 1,utilities.Utility.excelpath,"manageproduct"));
		manageproductpage = new ManageProductPage(driver);
		manageproductpage.clickmanageProduct().clickstatusYesNo();
		//System.out.println(manageproductpage.getbackgroundcolorofstatusbuttonyesno());
		
		
		
	
	
}
}