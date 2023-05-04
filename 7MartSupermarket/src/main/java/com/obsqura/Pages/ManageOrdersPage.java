package com.obsqura.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;

import utilities.WaitUtility;

public class ManageOrdersPage 
{
	WebDriver driver;
	public ManageOrdersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[contains(@class,'btn btn-warning btn-sm')]")WebElement assigndeliveryboybutton;
	@FindBy(xpath="//select[@id='delivery_boy_id']")WebElement selectdeliveryboy;
	@FindBy(xpath="//button[@name='assign_del']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath="//a[@class='btn btn-success btn-sm']")WebElement changestatus;
	@FindBy(xpath="//select[@id='status']")WebElement selectstatus;
	@FindBy(xpath="//button[@name='Update_st']")WebElement deliveryupdatebutton;
	@FindBy(xpath="//b[text()='Fatal error']")WebElement fatelerror;
	@FindBy(xpath="//a[text()='View']")WebElement view;
	@FindBy(xpath="//h1[text()='Order Details']")WebElement gettextorderdetails;
	@FindBy(xpath="//a[@class='btn btn-default']")WebElement backbutton;
	@FindBy(xpath="//h1[text()='List Orders']")WebElement listordertext;
	


	
	public String gettextofListOrderpage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(listordertext);
	}
	
	public ManageOrdersPage ClickonbackButton()
	{
			WaitUtility.waitForElementClickable(driver, backbutton);
			PageUtility.clickOnElement(backbutton);
			return this;
			 
		
	}
	public String gettextoforderdetails()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(gettextorderdetails);
	}
	public ManageOrdersPage ClickonViewButton()
	{
			WaitUtility.waitForElementClickable(driver, view);
			PageUtility.clickOnElement(view);
			return this;
			 
		
	}
	public String geterrormessage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(fatelerror);
	}
	public boolean ClickonDeliveryupdateButton()
	{
			WaitUtility.waitForElementClickable(driver, deliveryupdatebutton);
			PageUtility.clickOnElement(deliveryupdatebutton);
			return false;
			 
		
	}
	public ManageOrdersPage selectstatusofdelivery()
	{
		PageUtility.clickOnElement(selectstatus);
		PageUtility.selectDropdownbyText(selectstatus,"Delivered");
		return this;
	}
	public ManageOrdersPage Clickonstatusbutton()
	{
			WaitUtility.waitForElementClickable(driver, changestatus);
			PageUtility.clickOnElement(changestatus);
			return this;
		
	}
	public String getalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(alert);
	}
	public ManageOrdersPage ClickonupdateButton()
	{
			WaitUtility.waitForElementClickable(driver, updatebutton);
			PageUtility.clickOnElement(updatebutton);
			return this;
		
	}
	public ManageOrdersPage selectdeliveryBoyname()
	{
		PageUtility.clickOnElement(selectdeliveryboy);
		PageUtility.selectDropdownbyText(selectdeliveryboy,"arun");
		return this;
	}
	public ManageOrdersPage ClickonAssignDeliveryboyButton()
	{
			WaitUtility.waitForElementClickable(driver, assigndeliveryboybutton);
			PageUtility.clickOnElement(assigndeliveryboybutton);
			return this;
		
	}

}
