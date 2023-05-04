package com.obsqura.Pages;

import java.util.List;

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
	@FindBy(xpath="//span[text()='Fruits1319802369']")List<WebElement> gettext;
	@FindBy(xpath="//a[contains(@class,'btn btn-sm btn btn-danger btncss')]")WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alerttext; 
	@FindBy(xpath="//div[@class='action-buttons']")WebElement viewmore; 
	@FindBy(xpath="//td[@colspan='10']//b")WebElement getcolumn;
	@FindBy(xpath="//p[text()='Expense Category']")WebElement expensecategory;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editbutton;
	@FindBy(xpath="//input[@name='name']")WebElement edittitle;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebuttonedit; 
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement existalert;
	@FindBy(xpath="//button[@class='close']")WebElement close;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement delete;


	
	
	public ManageExpensePage clickOndeleteButtonUpdatepage()
	{
		WaitUtility.waitForElementClickable(driver,delete);
		PageUtility.clickOnElement(delete);
		driver.switchTo().alert().accept();
		WaitUtility.pageLoadWait(driver);
		return this;	
	}
	public ManageExpensePage closealert()
	{
		close.click();
		return this;
	}
	public String gettextofexistalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(existalert);
		
	}
	public ManageExpensePage clickOnUpdateButton()
	{
		WaitUtility.waitForElementClickable(driver,updatebuttonedit);
		updatebuttonedit.submit();
		return this;
		
	}
	public ManageExpensePage editvalueintitlefield(String title)
	{
		PageUtility.clearElement(edittitle);
		PageUtility.enterText(edittitle,title);
		return this;
	}
	public ManageExpensePage clickOnEditButton()
	{
		PageUtility.getattributeelementofhref(editbutton);
		WaitUtility.waitForElementClickable(driver,editbutton);
		PageUtility.clickOnElement(editbutton);
		
		
		return this;
		
	}
	public ManageExpensePage clickOnmanagecategoryLink()
	{
		WaitUtility.waitForElementClickable(driver,expensecategory);
		PageUtility.getattributeelementofhref(expensecategory);
		expensecategory.click();
		
		return this;
		
	}
	
	public boolean gettextofcolumnviewmore()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.isElementDisplayed(getcolumn);
	
	}
	public ManageExpensePage clickOnviewmoreButton()
	{
		WaitUtility.waitForElementClickable(driver,viewmore);
		PageUtility.clickOnElement(viewmore);
		return this;
		
	}
	
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
	
	public ManageExpensePage clickOnmanageexpense()
	{
		WaitUtility.waitForElementClickable(driver,expense);
		PageUtility.clickOnElement(expense);
		WaitUtility.pageLoadWait(driver);
		return this;
		
	}
	public ManageExpensePage clickOnmanageexpenseLink()
	{
		WaitUtility.waitForElementClickable(driver,manageexpense);
		PageUtility.clickOnElement(manageexpense);
		return this;
		
	}
}
