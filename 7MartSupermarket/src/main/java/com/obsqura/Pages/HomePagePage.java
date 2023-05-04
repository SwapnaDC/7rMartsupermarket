package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePagePage
{
	WebDriver driver;
	public HomePagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//p[text()='Manage Product']")WebElement manageproduct; 
	@FindBy(xpath="//h1[text()='List Products']")WebElement listproduct;
	@FindBy(xpath="//p[text()='Dashboard']//parent::a")WebElement dashboard;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")WebElement gettextofpage;

	public String gettextofListProduct()
	{
		return gettextofpage.getText();
	}
	public void clickManageProduct()
	{
		PageUtility.clickOnElement(manageproduct);
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	public String getbackgroundColorofDashBoard()
	{
		return PageUtility.getCssvalueofbuttonElement(dashboard,"background-color");
	}
	public String getcurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
