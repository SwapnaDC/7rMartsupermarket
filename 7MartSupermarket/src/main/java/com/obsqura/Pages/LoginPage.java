package com.obsqura.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='username']")WebElement usernameelement;
	@FindBy(xpath="//input[@name='password']")WebElement passwordelement;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement loginbuttonelement;
	@FindBy(xpath="//input[@id='remember']")WebElement remembercheckbox; 
	@FindBy(xpath="//span[text()='7rmart supermarket']")WebElement gettext7mart;
	@FindBy (xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")WebElement geterroralerttext;
	@FindBy(xpath="//a[text()='Home']")WebElement hometext;
	
	public boolean usernamefieldIsDisplayed()
	{
		return PageUtility.isElementDisplayed(usernameelement);
	}
	public boolean passwordFieldISDiplayed()
	{
		return PageUtility.isElementDisplayed(passwordelement);
	}
	
	public boolean loginbuttonIsEnabled()
	{
		return PageUtility.isElementEnabled(loginbuttonelement);
	}
	public LoginPage loginbuttonclick()
	{
		PageUtility.clickOnElement(loginbuttonelement);
		return this;
	}
	
	public boolean rememberCheckBoxisSelected()
	{
		return PageUtility.isElementSelected(remembercheckbox);
	}
	public void ClickrememberCheckBox()
	{
		PageUtility.clickOnElement(remembercheckbox);
	}
	
	public LoginPage usernameText(String username)
	{
		PageUtility.enterText(usernameelement, username);
		return this;
	}
	public LoginPage passwordText(String password)
	{
		PageUtility.enterText(passwordelement, password);
		return this;
	}
	
	public String geturlofCurrentpage()
	{
		return driver.getCurrentUrl();
	}
	public String alertmessage()
	{
		return geterroralerttext.getText();
	}
	public String getTextHomePage()
	{
		return PageUtility.getElementText(gettext7mart);
	}
	
	
	
	
	
	
	
}
