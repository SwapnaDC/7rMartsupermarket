package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class PushNotificationPage
{
	WebDriver driver;
	public PushNotificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Push Notifications']//parent::a")WebElement push;
	@FindBy(xpath="//h3[@class='card-title']")WebElement getpagetext; 
	@FindBy(xpath="//input[@id='title']")WebElement entertitle;
	@FindBy(xpath="//input[@id='description']")WebElement enterdiscription;
	@FindBy(xpath="//button[@name='create']")WebElement sendbutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement getalertmessagefield;
	
	public boolean getalertmessagefieldisDisplayed()
	{
		return PageUtility.isElementDisplayed(getalertmessagefield);
	}
	public String gettextofalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return getalertmessagefield.getText();
	}
	public boolean buttenisenabled()
	{
		
		return PageUtility.isElementEnabled(sendbutton);
	}
	public PushNotificationPage cliclOnsendButton()
	{
		WaitUtility.waitForElementClickable(driver, sendbutton);
		PageUtility.clickOnElement(sendbutton);
		return this;
	}
	public boolean discriptionisDisplayed()
	{
		return PageUtility.isElementDisplayed(enterdiscription);
	}
	public PushNotificationPage enterdiscritioninthetitleField(String discription)
	{
		PageUtility.enterText(enterdiscription, discription);
		return this;
		
	}
	public boolean titleisDisplayed()
	{
		return PageUtility.isElementDisplayed(entertitle);
	}
	public PushNotificationPage entertitleinthetitleField(String title)
	{
		PageUtility.enterText(entertitle, title);
		return this;
	}
	public PushNotificationPage clickOnpushnotification()
	{
		WaitUtility.waitForElementClickable(driver, push);
		PageUtility.clickOnElement(push);
		return this;
	}
	public String gettextofpushnotificationinfoPage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.getElementText(getpagetext);
	}
	
}
