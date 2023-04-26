package com.obsqura.Pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class SelectDashbordCategory
{
	WebDriver driver;
	public SelectDashbordCategory(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']/a")List<WebElement> moreinfolink;//20
	@FindBy(xpath="//ul[contains(@role,'menu')]//a")List<WebElement> menuitemslink;
	@FindBy(xpath="//i[contains(@class,'fas fa-angle-left right')]")WebElement dropdownlist;
	
	
	
	
	
	public void selectDashboardDropdownListCategoryLink(String dropdownlistpages)
	{
		
		for(WebElement dropdowncategory:moreinfolink)
		{
			if(dropdowncategory.getText().equals(dropdownlistpages))
			{
				WaitUtility.pageLoadWait(driver);
				dropdowncategory.click();
				break;
			}
			
		}
		
	}
	public void selectMoreinfoCategoryLink(String moreinfolinkpages)
	{
		
		for(WebElement moreinfocategory:moreinfolink)
		{
			if(PageUtility.getattributeelementofhref(moreinfocategory).equals(moreinfolinkpages))
			{
				WaitUtility.pageLoadWait(driver);
				PageUtility.clickOnElement(moreinfocategory);
				WaitUtility.pageLoadWait(driver);
				break;
			}
		}
		
	}
	
	public void selectdahsBoardCategoryLink(String dashboardmenulink)
	{
		
		for(WebElement dashcategory:menuitemslink)
		{
			if(PageUtility.getattributeelementofhref(dashcategory).equals(dashboardmenulink))
			{
				WaitUtility.pageLoadWait(driver);
				PageUtility.clickOnElement(dashcategory);
				WaitUtility.pageLoadWait(driver);
				break;
			}
		}
		
	}
	
	
	
	public void selectdashboardMenuLink(String dashboardmenulink)
	{
		 
		for(WebElement category:menuitemslink)
		{
			if(category.getText().equals(dashboardmenulink))
			{
				category.click();
				break;
			}
		}
	}
}
