package com.obsqura.Pages;




import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage 
{
	WebDriver driver;
	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//select[@id='country_id']")WebElement entercountry;
	@FindBy(xpath="//select[@id='st_id']")WebElement state;
	@FindBy(xpath="//input[@id='location']")WebElement location;
	@FindBy(xpath="//input[@id='delivery']")WebElement deliverycharge;
	@FindBy(xpath="//button[text()='Save']")WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement alertmessage;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	@FindBy(xpath="//select[@id='country_id']")WebElement selectcountry;
	@FindBy(xpath="//select[@id='st_id']")WebElement selectstate;
	@FindBy(xpath="//button[@name='Search']")WebElement searchdetails;
	@FindBy(xpath="//td[text()='London']")WebElement gettext;
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//tbody//tr//td")List<WebElement> tablevalues;
	
	
	
	
	
	public ManageLocationPage SearchButtonclick()
	{
		WaitUtility.waitForElementClickable(driver, searchdetails);
		PageUtility.clickOnElement(searchdetails);
		WaitUtility.pageLoadWait(driver);
		return this;
	}
	public ManageLocationPage clickstate()
	{
		WaitUtility.pageLoadWait(driver);
		PageUtility.clickOnElement(selectstate);
		PageUtility.selectDropdownbyText(selectstate,"Birmingham");
		return this;
	}
	public ManageLocationPage clickcountry()
	{
		PageUtility.clickOnElement(selectcountry);
		PageUtility.selectDropdownbyText(selectcountry,"United Kingdom");
		return this;
	}
	public ManageLocationPage clickOnSearchButton()
	{
		WaitUtility.waitForElementClickable(driver, searchbutton);
		PageUtility.clickOnElement(searchbutton);
		return this;
	}
	public String getalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return alertmessage.getText();
	}
	public ManageLocationPage clickOnsaveButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver, savebutton);
		PageUtility.clickOnElement(savebutton);
		return this;
	}
	public ManageLocationPage entervalueinDeliverychagerField(String value)
	{
		PageUtility.enterText(deliverycharge,value);
		return this;
	}
	public ManageLocationPage entervalueinLocationField(String pass)
	{
		PageUtility.enterText(location,pass);
		return this;
	}
	public void fakerlocation()
	{
		FakerUtility.fakerplace();
	}
	public ManageLocationPage clickOnstate()
	{
		PageUtility.clickOnElement(state);
		PageUtility.selectDropdownbyIndex(state,8);
		return this;
	}
	public ManageLocationPage clickOnCountry()
	{
		PageUtility.clickOnElement(entercountry);
		PageUtility.selectDropdownbyIndex(entercountry,1);
		return this;
	}
	public ManageLocationPage clickOnNewButton()
	{
		WaitUtility.waitForElementClickable(driver, newbutton);
		PageUtility.clickOnElement(newbutton);
		return this;
	}

}
