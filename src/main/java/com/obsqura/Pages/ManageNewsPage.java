package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage
{
	WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenewsclick;
	@FindBy(xpath="//p[contains(text(),'Manage Content')]")WebElement managecontent;
	@FindBy (xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newstextarea;
	@FindBy(xpath="//button[@name='create']")WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement alertmessage;
	
	
	
	
	
	
	public ManageNewsPage enterNewsinNewsField(String news)
	{
	
		PageUtility.enterText(newstextarea,news);
		return this;
	}
	public void News()
	{
		FakerUtility.fakerEnterNews(null);
	}
	
	
	
	
	
	
	public String alertMessageOfNewsUpdated()
	{
		WaitUtility.pageLoadWait(driver);
		return alertmessage.getText();
	}
	public ManageNewsPage clickOnmanagecontentLink()
	{
		WaitUtility.waitForElementClickable(driver,managecontent);
		PageUtility.clickOnElement(managecontent);
		return this;
		
	}
	public ManageNewsPage cliclOnNewsSaveButton()
	{
		PageUtility.clickOnElement(savebutton);
		return this;
		
	}
	public ManageNewsPage cliclOnmanageNewsLink()
	{
		PageUtility.clickOnElement(managenewsclick);
		return this;
		
	}
	public ManageNewsPage cliclOnNewButton()
	{
		PageUtility.clickOnElement(newbutton);
		return this;
		
	}
	
}
