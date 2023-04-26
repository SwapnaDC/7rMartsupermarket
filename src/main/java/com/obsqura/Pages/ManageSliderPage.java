package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
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
	
	
	public ManageSliderPage enterlink(String path)
	{

		PageUtility.enterText(link,path);
		return this;
	}
	public ManageSliderPage clickOnChooseButton()
	{
			WaitUtility.waitForElementClickable(driver, clickchoosebutton);
			PageUtility.clickAndHoldElement(clickchoosebutton, driver);
			WaitUtility.pageLoadWait(driver);
			return this;
		
	}
	public ManageSliderPage clickOnNewButton()
	{
			WaitUtility.waitForElementClickable(driver, newbutton);
			PageUtility.clickOnElement(newbutton);
			return this;
		
	}

}
