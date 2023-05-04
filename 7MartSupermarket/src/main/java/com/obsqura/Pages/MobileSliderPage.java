package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage
{
	WebDriver driver;
	public MobileSliderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public String getDeletedalertMessage()
	{
		WaitUtility.pageLoadWait(driver);
		return alert.getText();
	}
	
	public void cliclOnDeleteButton()
	{
		WaitUtility.waitForElementClickable(driver, deletebutton);
		PageUtility.clickOnElement(deletebutton);
		driver.switchTo().alert().accept();
	}
}
