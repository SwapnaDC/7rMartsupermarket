package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.RandomDataUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageFooterTextPage
{
	WebDriver driver;
	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//p[text()='Manage Footer Text']")WebElement footertext;
	@FindBy(xpath="//p[contains(text(),'Manage Content')]")WebElement content;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement editbutton;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement enteraddress;
	@FindBy(xpath="//input[@id='email']")WebElement eneteremail;
	@FindBy(xpath="//input[@id='phone']")WebElement enetephone;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessageofupdation;
	
	
	
	
	public boolean getalertmessagefieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(alertmessageofupdation);
	}
	public String gettextofalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return alertmessageofupdation.getText();
	}
	public ManageFooterTextPage cliclOnupdateButton()
	{
		PageUtility.clickOnElement(updatebutton);
		return this;
	}
	public ManageFooterTextPage entervalueinPhoneNoField(String number)
	{
		PageUtility.clearElement(enetephone);
		PageUtility.enterText(enetephone,number);
		return this;
	}
	
	public void Number()
	{
		RandomDataUtility.fakerPhoneNo();
	}
	public ManageFooterTextPage entervalueinEmailField(String email)
	{
	    PageUtility.clearElement(eneteremail);
		PageUtility.enterText(eneteremail,email);
		return this;
	}
	
	public void Email()
	{
		RandomDataUtility.fakerEmailId();
	}
	public ManageFooterTextPage entervalueinAddressField(String address)
	{
		PageUtility.clearElement(enteraddress);
		PageUtility.enterText(enteraddress,address);
		return this;
	}
	
	public void Address()
	{
		RandomDataUtility.fakerAddress();
	}
	
	public ManageFooterTextPage clickOneditbutton()
	{
		WaitUtility.waitForElementClickable(driver,editbutton);
		PageUtility.clickOnElement(editbutton);
		return this;
	}
	public ManageFooterTextPage clickOnmanagefootertextLink()
	{
		WaitUtility.waitForElementClickable(driver,footertext);
		PageUtility.clickOnElement(footertext);
		return this;
	}
	public ManageFooterTextPage clickOnmanagecontentLink()
	{
		WaitUtility.waitForElementClickable(driver,content);
		PageUtility.clickOnElement(content);
		return this;
	}
}
