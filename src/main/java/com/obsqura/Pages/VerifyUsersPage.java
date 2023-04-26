package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class VerifyUsersPage
{
	WebDriver driver;
	public VerifyUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='action-buttons']")WebElement clickshowtitle;
	@FindBy(xpath="//span[@class='badge bg-warning']")WebElement statuschange;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement result;
	
	
	public String gettextofresultnotfound()
	{
		WaitUtility.pageLoadWait(driver);
		return result.getText();
	}
	public String gettextofalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return alertmsg.getText();
	}
	public VerifyUsersPage clickOnstatusButton()
	{
		WaitUtility.waitForElementClickable(driver, statuschange);
		PageUtility.clickOnElement(statuschange);
		return this;
	}
	public VerifyUsersPage clickOnviewtitleButton()
	{
		WaitUtility.waitForElementClickable(driver, clickshowtitle);
		PageUtility.clickOnElement(clickshowtitle);
		driver.switchTo().alert().dismiss();
		return this;
	}
}
