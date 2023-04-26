package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpensePage
{
	WebDriver driver;
	public ManageExpensePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[contains(text(),'Manage Expense')]")WebElement manageexpense;
	@FindBy(xpath="//p[text()='Manage Expense']")WebElement expense;
	@FindBy(xpath="//div[@class='action-buttons']")WebElement clickarrow;
	@FindBy(xpath="//span[text()='Icecream_20_09_2022_08_30']")WebElement gettext;
	@FindBy(xpath="//a[contains(@class,'btn btn-sm btn btn-danger btncss')]")WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerttext; 

	
	public String gettextofalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(alerttext);
	}
	public ManageExpensePage clickOndeleteButton()
	{
		WaitUtility.waitForElementClickable(driver,deletebutton);
		PageUtility.clickAndHoldOnElement(deletebutton, driver);
		PageUtility.clickOnElement(deletebutton);
		driver.switchTo().alert().accept();
		WaitUtility.pageLoadWait(driver);
		return this;
		
	}
	public String gettextofdetails()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(gettext);
	}
	public ManageExpensePage clickOnshowmorearrow()
	{
		WaitUtility.waitForElementClickable(driver,clickarrow);
		PageUtility.clickAndHoldOnElement(clickarrow, driver);
		PageUtility.clickOnElement(clickarrow);
		WaitUtility.pageLoadWait(driver);
		return this;
		
	}
	public ManageExpensePage clickOnmanageexpense()
	{
		WaitUtility.waitForElementClickable(driver,expense);
		PageUtility.clickOnElement(expense);
		WaitUtility.pageLoadWait(driver);
		return this;
		
	}
	public ManageExpensePage clickOnmanageexpenseLink()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver,manageexpense);
		PageUtility.clickOnElement(manageexpense);
		return this;
		
	}
}
