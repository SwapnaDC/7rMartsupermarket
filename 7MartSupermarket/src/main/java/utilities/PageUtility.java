package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility
{
	

	public static String  getattributeelementofhref(WebElement element)
	{
		return element.getAttribute("href");
	}
		public static void clickOnElement(WebElement element)
		{
			element.click();
		}		
		public boolean isDisplay(WebElement element) 
		{
			boolean status = element.isDisplayed();
			return status;
		}
		public boolean isEnable(WebElement element)
		{
			boolean status=element.isEnabled();
			return status;
			
		}
		public boolean isSelect(WebElement element)
		{
			boolean status=element.isSelected();
			return status;
			
		}
		public static String  getattributeelement(WebElement element,String attribute)
		{
			return element.getAttribute(attribute);
		}
		
		public static String getCssvalueofbuttonElement(WebElement element, String valueName  )
		{
			return element.getCssValue(valueName);
		}
		
		
		public static void clearElement(WebElement element)
		{
			element.clear();
		}
		
		public static WebElement enterText(WebElement element, String value) 
		{
			element.sendKeys(value);
			return element;
		}
		
		public static void sendKey(WebElement element, String s) 
		{
			element.sendKeys(s);
		}
		public static String getElementText(WebElement element) 
		{
			return element.getText();
		}
		
		
		
		
		public static void clickAndHoldOnElement(WebElement element, WebDriver driver) 
		{
			Actions actions = new Actions(driver);
			actions.clickAndHold(element).build().perform();
		}
		public static void clickAndHoldElement(WebElement element, WebDriver driver) 
		{
			Actions actions = new Actions(driver);
			actions.clickAndHold(element).perform();
		}
		public static void actionButtonClickElement(WebElement element,WebDriver driver)
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
		public static void mouseOverElement(WebElement element,WebDriver driver)
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(element).build().perform();
		}
		public static void doubleClickElement(WebElement element, WebDriver driver)
		{
			Actions actions=new Actions(driver);
			actions.doubleClick(element).perform();
		}
		public static void rightClickElement(WebElement element,WebDriver driver)
		{
			Actions actions=new Actions(driver);
			actions.contextClick(element).perform();
		}
		public static void dragAndDropClickElement(WebElement sourceelement,WebElement destinationelement,WebDriver driver)
		{
			Actions actions=new Actions(driver);
			actions.clickAndHold(sourceelement).moveToElement(destinationelement).release(destinationelement).build().perform();
		}
		
		
		
		
		
		
		public static void selectDropdownbyText(WebElement element, String text) 
		{
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}
		public static void selectDropdownbyIndex(WebElement element, int index) 
		{
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		public static WebElement enterIntValue(WebElement element, CharSequence[] value) 
		{
			element.sendKeys(value);
			return element;
		}
		
		
		
		public static Boolean isElementDisplayed(WebElement element) 
		{
			return element.isDisplayed();
		}
		public static Boolean isElementEnabled(WebElement element)
		{
			return element.isEnabled();
		}
		public static Boolean isElementSelected(WebElement element)
		{
			return element.isSelected();
		}
		
		
		
		public static void sendKeys(WebDriver driver,WebElement element,String input)
		{
			JavascriptExecutor Js1 = (JavascriptExecutor)driver;
			Js1.executeScript("arguments[0].value='input';", element);
		}
		public static void clickJavaScriptexecutor(WebDriver driver,WebElement element) 
		{
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("arguments[0].click();", element);
		}
		public static void ScrollBy(WebDriver driver) 
		{
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("window.scrollBy(0,2500)");
		}
		public static void stopPageRefresh(WebDriver driver) 
		{
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("window.stop();");
		}
		public String getToolTip(WebElement element) 
		{
			return element.getAttribute("title");
		}
		public void getClickElement(WebElement element) 
		{
			element.click();
		}
		public void mediumDelay(int x) throws InterruptedException 
		{
			
		}
		public void selectFuncbyindex(WebElement element, int index) 
		{
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		public void selectFuncbyValue(WebElement element, String value) 
		{
			Select select1 = new Select(element);
			select1.selectByValue(value);
		}
		public String selectFuncbyVisibletext(WebElement element, String visibletext) 
		{
			Select select = new Select(element);
			select.selectByVisibleText(visibletext);
			WebElement selectedValue = select.getFirstSelectedOption();
			return (selectedValue.getText());
		}
		public String FirstSelectedOption(WebElement element) 
		{
			Select select1 = new Select(element);
			String firstoption = select1.getFirstSelectedOption().getText();
			return (firstoption);
		}
		public List<WebElement> getAllOptions(Select s) 
		{
			List<WebElement> op = s.getOptions();
			return op;
		}
		
		
		
		
		
		public List<String> convertToStringList(List<WebElement> weList) 
		{
			List<String> strList = new ArrayList<String>();
			for (int i = 0; i < weList.size(); i++) 
			{
				strList.add(weList.get(i).getText());
			}
			return strList;
		}
		public String stylePropertyValidation(WebElement element, String propertyType) 
		{
			return element.getCssValue(propertyType);
		}
		public boolean isSelected(WebElement element) 
		{
			return element.isSelected();
		}
		public List<String> addList(List<String>list,String s) 
		{
			list.add(s);
			return list;
		}
		public void alertHandlingaccept(WebDriver driver) 
		{
			driver.switchTo().alert().accept();
		}
		public void alerttext(WebDriver driver) 
		{
			 driver.switchTo().alert().getText();
		}	
		
		
		public boolean getElementTextList(List<WebElement> chkList, String element) 
		{	
			boolean value = true;
			for (int i = 0; i < chkList.size(); i++) 
			{
				String text = chkList.get(i).getText();
				if (!text.equals(element))
				{
					value = false;
				}
			}
			return value;
		}
		public boolean compareLists(List<String> actuallist, List<String> expectedlist) 
		{
			boolean value = true;
			for (int i = 0; i < actuallist.size(); i++) 
			{
				if (!actuallist.get(i).equals(expectedlist.get(i))) 
				{
					value = false;
				}
			}

			return value;
		}
		public void managSliderList(List<WebElement> actuallist, List<WebElement> element) 
		{
			for (int i = 0; i < actuallist.size(); i++) 
			{
				String text = actuallist.get(i).getText();
				if (!text.equals(element)) 
				{
					break;
				}
			}
		}
		
}
