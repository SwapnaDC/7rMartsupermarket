package Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class HomePagePage
{
	WebDriver driver;
	public HomePagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//p[text()='Manage Product']")WebElement manageproduct; 
	@FindBy(xpath="//input[@name='username']")WebElement usernameelement;
	@FindBy(xpath="//input[@name='password']")WebElement passwordelement;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement loginbuttonelement;
	@FindBy(xpath="//input[@id='remember']")WebElement remembercheckbox; 
	@FindBy(xpath="//span[text()='7rmart supermarket']")WebElement projecttitle;
	@FindBy(xpath="//p[text()='Dashboard']//parent::a")WebElement dashboard;

	public void usernameText(String username)
	{
		PageUtility.enterText(usernameelement, username);
	}
	public void passwordText(String password)
	{
		PageUtility.enterText(passwordelement, password);
	}
	public void loginbuttonclick()
	{
		PageUtility.clickOnElement(loginbuttonelement);
	}
	public void clickManageProduct()
	{
		PageUtility.clickOnElement(manageproduct);
	}
	public String gettitle()
	{
		return PageUtility.getElementText(projecttitle);
	}
	public String getbackgroundColorofDashBoard()
	{
		return PageUtility.getCssvalueofbuttonElement(dashboard,"background-color");
	}
	
}
