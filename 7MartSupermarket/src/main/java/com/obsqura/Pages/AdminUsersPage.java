package com.obsqura.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.RandomDataUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage
{
	WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
	@FindBy(xpath="//a[contains(@class,'btn btn-sm btn btn-danger btncss')]")WebElement deletebutton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")WebElement deletealert; 
	@FindBy(xpath="//a[@role='button']")WebElement lockbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement statuschangealert;
	@FindBy(xpath="//span[@class='badge bg-warning']")WebElement statusfield;
	

	public boolean displaySamePage()
	{
		WaitUtility.pageLoadWait(driver);
		return PageUtility.isElementDisplayed(statusfield);
	}
	public String getstatuschangealertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return statuschangealert.getText();
	}
	public AdminUsersPage clickOnlockButton()
	{
		WaitUtility.waitForElementClickable(driver, lockbutton);
		PageUtility.clickOnElement(lockbutton);
		return this;
	}
	public String getdeletealertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return deletealert.getText();
	}
	public AdminUsersPage clickOncancelButton()
	{
		WaitUtility.waitForElementClickable(driver, deletebutton);
		PageUtility.clickOnElement(deletebutton);
		driver.switchTo().alert().dismiss();
		return this;
	}
	public AdminUsersPage clickOndeleteButton()
	{
		WaitUtility.waitForElementClickable(driver, deletebutton);
		PageUtility.clickOnElement(deletebutton);
		driver.switchTo().alert().accept();
		return this;
	}
	public String getalertmessage()
	{
		WaitUtility.pageLoadWait(driver);
		return statuschangealert.getText();
	}
	public AdminUsersPage cliclOnnewButton()
	{
		WaitUtility.waitForElementClickable(driver, newbutton);
		PageUtility.clickOnElement(newbutton);
		return this;
	}
	public AdminUsersPage entervalueinUsernameField(String user)
	{
		PageUtility.enterText(username, user);
		return this;
	}
	
	public void Username()
	{
		RandomDataUtility.fakerUsername();
	}
	public AdminUsersPage entervalueinPasswordField(String pass)
	{
		PageUtility.enterText(password,pass);
		return this;
	}
	
	public void Password()
	{
		RandomDataUtility.fakerPassword();
	}
	public AdminUsersPage clickOnUsertype()
	{
		PageUtility.clickOnElement(usertype);
		PageUtility.selectDropdownbyText(usertype,"Admin");
		
		return this;
	}
	public AdminUsersPage cliclOnsaveButton()
	{
		WaitUtility.waitForElementClickable(driver, savebutton);
		PageUtility.clickOnElement(savebutton);
		return this;
	}
	

}
