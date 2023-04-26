package com.obsqura.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class DashboardCategory 
{
	WebDriver driver;
	public DashboardCategory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//li[contains(@class,'nav-item')]//p")List<WebElement> dashboarditems;

	
	public void dashboardItemsredirectingtoPages(String links)
	{
		for(WebElement dashboardlinks:dashboarditems)
		{
			if(PageUtility.getattributeelementofhref(dashboardlinks).equals(links))
			{
				PageUtility.clickOnElement(dashboardlinks);
				break;
			}
		}
	}
	
}
