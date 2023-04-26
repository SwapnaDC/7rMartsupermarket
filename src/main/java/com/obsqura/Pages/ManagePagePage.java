package com.obsqura.Pages;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;


public class ManagePagePage
{
	WebDriver driver;
	public ManagePagePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Manage Product']//parent::a")WebElement manageproduct;
	@FindBy(xpath="//a[text()=' New']")WebElement newbutton;
	@FindBy (xpath="//input[@placeholder='Title']")WebElement entertitle;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	@FindBy(xpath="//button[@name='Search']")WebElement search;
	@FindBy(xpath="//a[text()='Reset']")WebElement resetbutton;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")WebElement searchresultnotfoundtext;
	@FindBy(xpath="//input[@id='title']")WebElement addtitle;
	@FindBy(xpath="//div[@role='textbox']")WebElement adddescription;
	@FindBy(xpath="//input[@id='page']")WebElement addpage;
	@FindBy(xpath="//button[text()='Save']")WebElement save;
	
	
	public ManagePagePage clicksaveButton()
	{
		PageUtility.ScrollBy(driver);
		WaitUtility.waitForElementClickable(driver, save);
		PageUtility.clickOnElement(save);
		return this;
	}
	public ManagePagePage entervalueinpageField(String page)
	{
		PageUtility.enterText(addpage, page);
		return this;
	}
	public ManagePagePage entervalueindiscriptionField(String descri)
	{
		PageUtility.enterText(adddescription, descri);
		return this;
	}
	public ManagePagePage entervalueintitleField(String title)
	{
		PageUtility.enterText(addtitle, title);
		return this;
	}
	
	public ManagePagePage clickNewButton()
	{
		WaitUtility.waitForElementClickable(driver, newbutton);
		PageUtility.clickOnElement(newbutton);
		return this;
	}
	public String gettextofsearchResultnotfoundintheSearchListPage()
	{
		return searchresultnotfoundtext.getText();
	}
	public String getcurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}
	public void clickOnManageProduct()
	{
		PageUtility.clickOnElement(manageproduct);
	}
	public String getbackgroundColorofNewButton()
	{
		return PageUtility.getCssvalueofbuttonElement(newbutton,"background-color");
	}
	public void clickOnNewButton()
	{
		PageUtility.clickOnElement(newbutton);
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	public boolean titletextBoxisDisplayed()
	{
		return PageUtility.isElementDisplayed(entertitle);
	}
	public ManagePagePage enterTitleinthetitlebox(String title)
	{
		
		PageUtility.enterText(entertitle,title);
		return this;
		
		
	}
	public boolean isenabledSearchButtontoGosearchPage()
	{
		
		return PageUtility.isElementEnabled(searchbutton);
		
		
	}
	
	public ManagePagePage clickOnSearchButtontoGosearchPage()
	{
		
		PageUtility.clickOnElement(searchbutton);
		return this;
		
	}
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}
	public boolean isEnabledSearchButtontofindPage()
	{
		return PageUtility.isElementEnabled(search);
	}
	public ManagePagePage clickOnSearchButtontofindPage()
	{
		PageUtility.clickOnElement(search);
		return this;
	}
	
	
	
	
	
	
}
