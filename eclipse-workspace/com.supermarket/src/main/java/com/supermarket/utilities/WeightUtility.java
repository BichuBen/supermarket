package com.supermarket.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WeightUtility 
{

	public static final long IMPLICIT_WAIT=5;
	public static final long PAGE_LOAD_WAIT=5;
	WebDriver driver;
	WebDriverWait wait;
	
	
	public WeightUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void implicitWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

	}
	public void pageLoadWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);

	}
	public void Elementvisible(WebDriver driver, String location)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(location)));

	}
	
	public void fWait(WebDriver driver,By locator)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(30))
	.pollingEvery(Duration.ofSeconds(5))
	.ignoring(Exception.class);


	WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {

	public WebElement apply(WebDriver driver) {

	if(driver.findElement(locator).isDisplayed())
	{
	 return driver.findElement(locator); 
	} 
	else
	return null;

	}
	});
	}
	
	public void selectElement(WebDriver driver, String target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));
	 
	}
	public void checkselection(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//waits for the element to be selected
		wait.until(ExpectedConditions.elementSelectionStateToBe(element,true));
	}


	public void textPresent(WebDriver driver, WebElement element,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element,"Total "));;
	}
	}


	

