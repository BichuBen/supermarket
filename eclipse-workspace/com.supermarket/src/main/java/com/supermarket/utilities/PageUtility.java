package com.supermarket.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{

	WebDriver driver;
	Actions actions;
	Select select;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectByIndex(WebElement element,int index)
	{
		select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value)
	{
		select=new Select(element);
		select.selectByValue(value);
	}
	
	public void clickUsingMouse(WebElement element)
	{
		actions=new Actions(driver);
		actions.click(element).build().perform();
	}
	
	public boolean checkIsVisible(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isClicked(WebElement element)
	{
		try
		{
			element.click();
			return false;
		}catch(Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}
	
	public void scrollAndClick(WebElement element)
	{
		int x=0;
		js=(JavascriptExecutor) driver;
		
		while(isClicked(element))//just upmethod
		{
			js.executeScript("window.scrollBy(0," + x + ")");
			x=x+20;

		}
	}
	

	
}
