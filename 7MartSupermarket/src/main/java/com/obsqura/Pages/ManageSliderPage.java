package com.obsqura.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class ManageSliderPage
{
	WebDriver driver;
	public ManageSliderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='main_img']")WebElement clickchoosebutton;
	@FindBy(xpath="//input[@id='link']")WebElement link;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement slideralert;
	
	
	public String getalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return slideralert.getText();
	}
	public ManageSliderPage clickOnsaveButton()
	{
			WaitUtility.waitForElementClickable(driver, savebutton);
			savebutton.submit();
			
			return this;
		
	}
	public ManageSliderPage enterlink()
	{
		WaitUtility.waitForElement(driver, link);
		link.sendKeys(ExcelUtility.getString(1, 0, GeneralUtility.excelpath,"slider"));
		return this;
	}
	
	public ManageSliderPage clickOnChooseButton()
	{
			WaitUtility.waitForElementClickable(driver, clickchoosebutton);
			clickchoosebutton.sendKeys(ExcelUtility.getString(3, 0, GeneralUtility.excelpath,"slider"));
			
			return this;
		
	}
	public ManageSliderPage clickOnNewButton()
	{
			WaitUtility.waitForElementClickable(driver, newbutton);
			PageUtility.clickOnElement(newbutton);
			return this;
		
	}

}
