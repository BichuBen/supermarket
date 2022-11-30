package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class GeneralUtilities
{
WebDriver driver;
Actions actions;
Robot robot;


public GeneralUtilities(WebDriver driver)
{
	this.driver=driver;
}


public GeneralUtilities()
{
	
}


	public String getTextofElement(WebElement element)
	{
			return element.getText();
	}

	public List<String> get_TextofElement(String xpath)
	{
		List<String> texts=new ArrayList();
		List<WebElement> elements=driver.findElements(By.xpath(xpath));
		
		for(WebElement i:elements) 
		{
			texts.add(i.getText());
		}
		
		return texts;
		
	}

	
	public String get_AttributeVaue(WebElement element,String attributeName)
	{
		return element.getAttribute(attributeName);
	}


	public String get_CssValue(WebElement element, String name) 
	{
		return element.getCssValue(name);
	}

	
	public boolean is_Displayed(WebElement element)
	{
		return element.isDisplayed();
	}

	public boolean is_Selected(WebElement element)
	{
		return element.isSelected();
	}

	public boolean is_Enabled(WebElement element)
	{
		return element.isEnabled();
	}

	public void clearText(WebElement element)
	{
		element.clear();
	}

	public String getCurrenturl()
	{
	 return driver.getCurrentUrl();
	}

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void enterText(WebElement element,String text)
	{
		element.sendKeys(text);
	}


	public boolean isExpectedTextPresent(WebElement element,String expectedtext)
	{
		return element.getText().contains(expectedtext);//comparing texts
	}

	public String get_TimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}

	public String get_RandomNo()
	{
		Random random=new Random();
		int x=random.nextInt(100);
		return String.valueOf(x);
	}
	
	public void fileUploadUsingRobotClass(WebElement element,String imagename)//only pass webelement and imag name
	{
		try
		{
		
		actions=new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		robot = new Robot();
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\src\\main\\resources\\ImageFiles\\"+imagename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//copies file to clipboard ie cntrl+c;
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e)
			{
			
			e.printStackTrace();
			}

	}
}
