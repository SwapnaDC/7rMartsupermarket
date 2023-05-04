package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.RandomDataUtility;
import utilities.WaitUtility;

public class ManageContactPage
{
	WebDriver driver;
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[contains(text(),'Manage Content')]")WebElement content;
	@FindBy (xpath="//p[text()='Manage Contact']")WebElement contact;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement editphone;
	@FindBy(xpath="//input[@id='email']")WebElement editemail;
	@FindBy(xpath="//textarea[@name='address']")WebElement editaddress;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement editdeliverytime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement editcharge;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement updatealert;
	
	
	public String successalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return updatealert.getText();
	}
	public ManageContactPage clickOnUpdatebutton()
	{
		PageUtility.ScrollBy(driver);
		PageUtility.getattributeelementofhref(updatebutton);
		WaitUtility.waitForElementClickable(driver,updatebutton);
		updatebutton.submit();
		return this;
	}
	public ManageContactPage entervalueinAddressField(String address)
	{
		PageUtility.clearElement(editaddress);
		PageUtility.enterText(editaddress,address);
		return this;
	}
	public void Address()
	{
		RandomDataUtility.fakerAddress();
	}
	public ManageContactPage entervalueinEmailField(String email)
	{
		PageUtility.clearElement(editemail);
		PageUtility.enterText(editemail,email);
		return this;
	}
	
	public void Email()
	{
		RandomDataUtility.fakerEmailId();
	}
	public ManageContactPage entervalueinPhoneNoField(String number)
	{
		PageUtility.clearElement(editphone);
		PageUtility.enterText(editphone,number);
		return this;
	}
	public void Number()
	{
		RandomDataUtility.fakerPhoneNo();
	}
	
	public ManageContactPage clickOneditbutton()
	{
		PageUtility.getattributeelementofhref(editbutton);
		WaitUtility.waitForElementClickable(driver,editbutton);
		PageUtility.clickOnElement(editbutton);
		return this;
	}
	public ManageContactPage clickOnmanagecontentLink()
	{
		WaitUtility.waitForElementClickable(driver,content);
		PageUtility.clickOnElement(content);
		return this;
	}
	public ManageContactPage clickOnmanagecontactLink()
	{
		WaitUtility.waitForElementClickable(driver,contact);
		PageUtility.clickOnElement(contact);
		return this;
	}

}
