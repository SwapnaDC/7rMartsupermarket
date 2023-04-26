package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class DeliveryBoyPage
{
	WebDriver driver;
	public DeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement deliveryboynewbutton;
	@FindBy(xpath="//input[@id='name']")WebElement entername;
	@FindBy(xpath="//input[@id='email']")WebElement eneteremail;
	@FindBy(xpath="//input[@id='phone']")WebElement enetephone;
	@FindBy(xpath="//textarea[@id='address']")WebElement enteraddress;
	@FindBy(xpath="//input[@id='username']")WebElement enterusername;
	@FindBy(xpath="//input[@id='password']")WebElement enterpassword;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successalert;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deletesuccessalert;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement gottosearchpagebutton;
	
	@FindBy(xpath="//input[@id='un']")WebElement searchname;
	@FindBy(xpath="//input[@id='ut']")WebElement searchemail;
	@FindBy(xpath="//input[@id='ph']")WebElement searchphone;
	@FindBy(xpath="//button[@name='Search']")WebElement searchthedetailsbutton;
	@FindBy(xpath="//i[contains(@class,'fa fa-angle-double-down')]")WebElement clickshow;
	@FindBy(xpath="//span[text()='shyam']")WebElement showpassword;
	

	
	public DeliveryBoyPage cliclshowArrowAndGetPassword()
	{
		WaitUtility.pageLoadWait(driver);
		WaitUtility.waitForElementClickable(driver, clickshow);
		PageUtility.clickAndHoldElement(clickshow, driver);
		return this;
	}
	public DeliveryBoyPage cliclOnSearchButtontoGettheDetails()
	{
		WaitUtility.waitForElementClickable(driver, searchthedetailsbutton);
		PageUtility.clickOnElement(searchthedetailsbutton);
		WaitUtility.pageLoadWait(driver);
		return this;
	}
	public DeliveryBoyPage enteremailintheSearchField(String email)
	{
		PageUtility.enterText(searchemail,email);
		return this;
	}
	public DeliveryBoyPage enterphonenointheSearchField(String ph)
	{
		PageUtility.enterText(searchphone,ph);
		return this;
	}
	public DeliveryBoyPage enterNameintheSearchField(String name)
	{
		PageUtility.enterText(searchname,name);
		return this;
	}
	public DeliveryBoyPage cliclOnSearchButton()
	{
		WaitUtility.waitForElementClickable(driver, gottosearchpagebutton);
		PageUtility.clickOnElement(gottosearchpagebutton);
		return this;
	}
	public String deletedatasuccessfullyalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return deletesuccessalert.getText();
	}
	public void deletedeteils()
	{
		driver.switchTo().alert().accept();
	}
	public String getalertmessageofdelete()
	{
		return driver.switchTo().alert().getText();
	}
	public void cliclOnDeleteButton()
	{
		PageUtility.clickOnElement(deletebutton);
	}
	public String getAlertMessageOfDeliveryBoy()
	{
		WaitUtility.pageLoadWait(driver);
		return successalert.getText();
	}
	
	
	public boolean deliverybotnewButtonisEnabled()
	{
		return PageUtility.isElementEnabled(deliveryboynewbutton);
	}
	public void cliclOnNewButton()
	{
		PageUtility.clickOnElement(deliveryboynewbutton);
	}
	public void clickOnsaveButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver,savebutton);
		 PageUtility.clickOnElement(savebutton);
		 
	}
	
	
	
	public DeliveryBoyPage entervalueinEmailField(String email)
	{
	
		PageUtility.enterText(eneteremail,email);
		return this;
	}
	public boolean emailfieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(eneteremail);
	}
	public void Email()
	{
		FakerUtility.fakerEmailId();
	}
	
	
	public DeliveryBoyPage entervalueinNameField(String name)
	{
		PageUtility.enterText(entername,name);
		return this;
	}
	public boolean namefieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(entername);
	}
	
	public void Name()
	{
		FakerUtility.fakerEnterName();
	}
	
	
	
	public boolean phoneNumberfieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(enetephone);
	}
	public DeliveryBoyPage entervalueinPhoneNoField(String number)
	{
		PageUtility.enterText(enetephone,number);
		return this;
	}
	
	public void Number()
	{
		FakerUtility.fakerPhoneNo();
	}
	
	
	public boolean addressfieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(enteraddress);
	}
	public DeliveryBoyPage entervalueinAddressField(String address)
	{
		PageUtility.enterText(enteraddress,address);
		return this;
	}
	
	public void Address()
	{
		FakerUtility.fakerAddress();
	}
	
	
	public boolean usernamefieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(entername);
	}
	public DeliveryBoyPage entervalueinUsernameField(String user)
	{
		PageUtility.enterText(enterusername, user);
		return this;
	}
	
	public void Username()
	{
		FakerUtility.fakerUsername();
	}
	
	
	
	public boolean passwordfieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(enterpassword);
	}
	public DeliveryBoyPage entervalueinPasswordField(String pass)
	{
		PageUtility.enterText(enterpassword,pass);
		return this;
	}
	
	public void Password()
	{
		FakerUtility.fakerPassword();
	}
	
}
