package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductPage
{
	WebDriver driver;
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Manage Product']//parent::a")WebElement manageproduct;
	@FindBy(xpath="///span[text()='Limited']")WebElement limitedstatus;
	
	
	
	public ManageProductPage clickstatusYesNo()
	{
	
		WaitUtility.waitForElementClickable(driver, limitedstatus);
		PageUtility.clickOnElement(limitedstatus);
		return this;
	
	}
	public ManageProductPage clickmanageProduct()
	{
		WaitUtility.waitForElementClickable(driver, manageproduct);
		PageUtility.clickOnElement(manageproduct);
		return this;
	}
	
	
}
