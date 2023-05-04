package com.obsqura.Pages;




import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.RandomDataUtility;
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
	@FindBy(xpath="//input[@id='location']")WebElement enterlocation;
	@FindBy(xpath="//button[@name='Search']")WebElement searchdetails;
	@FindBy(xpath="//td[text()='Birmingham']")List<WebElement> gettext;

	
	
	
	public ManageLocationPage enterlocation(String loc)
	{
		
		PageUtility.enterText(location,loc);
		return this;
	}
	
	public ManageLocationPage SearchButtonclick()
	{
		WaitUtility.waitForElementClickable(driver, searchdetails);
		PageUtility.clickOnElement(searchdetails);
		WaitUtility.pageLoadWait(driver);
		return this;
	}
	public ManageLocationPage clickstate()
	{
		WaitUtility.waitForElementClickable(driver, selectstate);
		PageUtility.clickOnElement(selectstate);
		PageUtility.selectDropdownbyText(selectstate,"Birmingham");
		WaitUtility.waitForElement(driver, selectstate);
		
		return this;
	}
	public ManageLocationPage clickcountry()
	{
		PageUtility.clickOnElement(selectcountry);
		PageUtility.selectDropdownbyText(selectcountry,"United Kingdom");
		WaitUtility.waitForElement(driver, selectcountry);
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
		WaitUtility.waitForElement(driver, deliverycharge);
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
		WaitUtility.waitForElement(driver, location);
		RandomDataUtility.fakerplace();
	}
	public ManageLocationPage clickOnstate()
	{
		WaitUtility.waitForElement(driver, state);
		PageUtility.clickOnElement(state);
		PageUtility.selectDropdownbyIndex(state,8);
		return this;
	}
	public ManageLocationPage clickOnCountry()
	{
		WaitUtility.waitForElement(driver, entercountry);
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
	public boolean gettextoftable()
	{
		
		boolean valuestatus=false;
		for(WebElement value:gettext)
		{
			String textvalue=value.getText();	
			if(textvalue.contains("Birmingham"))
			{
				valuestatus=true;
				break;
			}
				
		}
		return valuestatus;
		
		
	}

}
