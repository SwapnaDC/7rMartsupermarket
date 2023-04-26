package com.obsqura.Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class SelectHomeCategory
{
	WebDriver driver;
	public SelectHomeCategory(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='More info ']")List<WebElement> homecategorypages;
	
	
	public void homepageCategoryRedirectionLink(String moreinfolink)
	{
		for(WebElement homecategory:homecategorypages)
		{
			if(PageUtility.getattributeelementofhref(homecategory).equals(moreinfolink))
			{
				PageUtility.clickOnElement(homecategory);
				break;
			}
		}
		
	}

}
