package Automation.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	@FindBy(xpath="//span[@class='brand-text font-weight-light']")WebElement gettext7mart;
	
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
	public void loginbuttonclick()
	{
		PageUtility.clickOnElement(loginbuttonelement);
	}
	
	public boolean rememberCheckBoxisSelected()
	{
		return PageUtility.isElementSelected(remembercheckbox);
	}
	public void usernameText(String username)
	{
		PageUtility.enterText(usernameelement, username);
	}
	public void passwordText(String password)
	{
		PageUtility.enterText(passwordelement, password);
	}
	
	public String getTextHomePage()
	{
		return PageUtility.getElementText(gettext7mart);
	}
	
	
	
	
	
	
}
