package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage
{
	WebDriver driver;
	public ManageOfferCodePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	@FindBy(xpath="//input[@name='un']")WebElement enteroffercode;
	@FindBy(xpath="//button[@name='Search']")WebElement search;
	@FindBy(xpath="//th[text()='Offer Code']//following::td")WebElement displayvalue;
	@FindBy(xpath="//span[@class='badge bg-success']")WebElement activestatus;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	
	public String getalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return alert.getText();
	}
	public ManageOfferCodePage clickonStatusbutton()
	{
		WaitUtility.waitForElementClickable(driver, activestatus);
		PageUtility.clickOnElement(activestatus);
		WaitUtility.pageLoadWait(driver);
		return this;
	}
	public String getvalueofthetable()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(displayvalue);
	}
	public ManageOfferCodePage clickOnsearch()
	{
			WaitUtility.waitForElementClickable(driver, search);
			PageUtility.clickOnElement(search);
			WaitUtility.pageLoadWait(driver);
			return this;
		
	}
	public ManageOfferCodePage entervalueintheoffercodefield(String offer)
	{
		PageUtility.clearElement(enteroffercode);
		PageUtility.enterText(enteroffercode,offer);
		return this;
	}
	public ManageOfferCodePage clickOnsearchButton()
	{
			WaitUtility.waitForElementClickable(driver, searchbutton);
			PageUtility.clickOnElement(searchbutton);
			return this;
		
	}

}
