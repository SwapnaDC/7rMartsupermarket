package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.RandomDataUtility;
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
	@FindBy(xpath="//a[@class='green bigger-140 show-details-btn']")WebElement clickarrow;
	@FindBy(xpath="//td[@colspan='5']")WebElement showpass;
	
	public boolean showpassword()
	{
		WaitUtility.waitForElement(driver, showpass);
		return PageUtility.isElementDisplayed(showpass);
		
	}
	public DeliveryBoyPage cliclOnArrow()
	{
		WaitUtility.waitForElementClickable(driver, clickarrow);
		clickarrow.click();
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
		 savebutton.submit();
		 
	}
	
	
	
	public DeliveryBoyPage entervalueinEmailField(String email)
	{
	
		PageUtility.enterText(eneteremail,email);
		return this;
	}
	
	public void Email()
	{
		RandomDataUtility.fakerEmailId();
	}
	
	
	public DeliveryBoyPage entervalueinNameField(String name)
	{
		PageUtility.enterText(entername,name);
		return this;
	}
	
	public void Name()
	{
		RandomDataUtility.fakerEnterName();
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
		RandomDataUtility.fakerPhoneNo();
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
		RandomDataUtility.fakerAddress();
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
		RandomDataUtility.fakerUsername();
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
		RandomDataUtility.fakerPassword();
	}
	
}
