package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePaymentPage
{
	WebDriver driver;
	public ManagePaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[text()='Manage Payment Methods']")WebElement paymentclick;	
	@FindBy(xpath="//i[@class='fa fa-lock']")WebElement statusbutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement updatedalertmessage;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement getalertmessage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successfullychangedalert;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement updatemessagealert;
	@FindBy(xpath="//th[text()='Contact']")WebElement contacttext;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newsbuttonnew;
	@FindBy(xpath="//textarea[@class='form-control']")WebElement text;
	@FindBy(xpath="//button[@name='create']")WebElement savebutton;
	@FindBy(xpath="//div[@class='col-sm-12']")WebElement alertget;
	@FindBy(xpath="//a[@role='button']")WebElement status;
	@FindBy(xpath="//a[contains(@class,'btn btn-sm btn btn-primary btncss')]")WebElement editbutton;
	@FindBy(xpath="//input[@id='name']")WebElement entertitle;
	@FindBy(xpath="//input[@id='limit']")WebElement enterlimit;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-warning')]")WebElement resetbutton;
	@FindBy(xpath="//h4[text()='Manage Payment Methods']")WebElement gettextfromthepage;
	
	
	public String gettextdebit()
	{
		WaitUtility.pageLoadWait(driver);
		return gettextfromthepage.getText();
	}
	public ManagePaymentPage clickOnresetButton()
	{
		PageUtility.getattributeelementofhref(resetbutton);
		WaitUtility.waitForElementClickable(driver, resetbutton);
		PageUtility.clickOnElement(resetbutton);
		return this;
	}
	public String getalertmessageofupdatedalert()
	{
		WaitUtility.pageLoadWait(driver);
		return updatemessagealert.getText();
	}
	public ManagePaymentPage cliclOnupdateButton()
	{
		PageUtility.clickOnElement(update);
		return this;
	}
	public ManagePaymentPage entervalueinlimitfield(String limit)
	{
		PageUtility.clearElement(enterlimit);
		PageUtility.enterText(enterlimit,limit);
		return this;
	}
	public ManagePaymentPage entervalueintitlefield(String title)
	{

		PageUtility.clearElement(entertitle);
		PageUtility.enterText(entertitle,title);
		return this;
	}
	public ManagePaymentPage clickOnEditButton()
	{
		
			PageUtility.getattributeelementofhref(editbutton);
			WaitUtility.waitForElementClickable(driver, editbutton);
			PageUtility.clickOnElement(editbutton);
			return this;
		
	}
	public String alertMessageofstatusSuccessfullychanged()
	{
		WaitUtility.pageLoadWait(driver);
		return successfullychangedalert.getText();
	}
	public String getbackgroundColorofActivestatus()
	{
		return PageUtility.getCssvalueofbuttonElement(status,"background-color");
	}
	public void clickOnStatus()
	{
		
			PageUtility.getattributeelementofhref(status);
			WaitUtility.waitForElementClickable(driver, status);
			getbackgroundColorofActivestatus().equals(status);
			PageUtility.clickOnElement(status);
		
	}
	public String gettextOfactivestatus()
	{
		WaitUtility.pageLoadWait(driver);
		return status.getText();
	}
	
	public String gettextofalertmessageupdated()
	{
		WaitUtility.pageLoadWait(driver);
		return updatedalertmessage.getText();
	}
	
	
	
	
	
	
	public ManagePaymentPage clickOneditbutton()
	{
		WaitUtility.waitForElementClickable(driver,editbutton);
		PageUtility.clickOnElement(editbutton);
		return this;
	}
	
	public void gettextofupdatedalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		 alertget.getText();
	}
	public void cliclOnssaveButton()
	{
		WaitUtility.waitForElementClickable(driver, savebutton);
		PageUtility.clickOnElement(savebutton);
	}
	
	public void entertitleinthetextareaField(String tarea)
	{
		
		PageUtility.enterText(text, tarea);
		WaitUtility.pageLoadWait(driver);
	}
	
	public void cliclOnnewButton()
	{
		WaitUtility.pageLoadWait(driver);
		WaitUtility.waitForElementClickable(driver, newsbuttonnew);
		PageUtility.clickOnElement(newsbuttonnew);
	}
	public String gettextofthvalue()
	{
		WaitUtility.pageLoadWait(driver);
		return contacttext.getText();
	}
	
	public String gettextofalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return getalertmessage.getText();
	}
	public void clickOnstatusButton()
	{
		
			WaitUtility.waitForElementClickable(driver, statusbutton);
			PageUtility.getattributeelementofhref(statusbutton);
	}
	public ManagePaymentPage clickOnmanagepayment()
	{
		
			WaitUtility.waitForElementClickable(driver, paymentclick);
			PageUtility.clickOnElement(paymentclick);
			return this;
	}
	public String gettextofpaymentPage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(paymentclick);
	}
}
