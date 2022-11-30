package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class PushNotificationPage 
{
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	
	@FindBy(linkText="Push Notifications")
	private WebElement pushnotificationButton;
	@FindBy(id="title")
	private WebElement titleField;
	@FindBy(id="description")
	private WebElement descriptionField;
	@FindBy(name="create")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement pushNotificationSuccessAlert;
	@FindBy(linkText="Reset")
	private WebElement ResetButton;
	
	
	
	
	
	public PushNotificationPage(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	public void clickOnPushNotification()
	{
		pushnotificationButton.click();
	}
	
	public void enterTitleField(String title)
	{
		titleField.sendKeys(title);
	}
	
	public void clickOnDescriptionField(String description)
	{
		descriptionField.sendKeys(description);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void clickOnResetButton()
	{
		ResetButton.click();
	}
	public String verifyPushNotoficationSuccessAlert(String title,String description)
	{
		clickOnPushNotification();
		enterTitleField(title);
		clickOnDescriptionField(description);
		clickOnSaveButton();
		if(pushNotificationSuccessAlert.isDisplayed()==true)
		{
			return pushNotificationSuccessAlert.getText();
		}
		else
			return null;
	}
	
	public boolean clearTitlefieldUsingResetButton(String title)
	{
		clickOnPushNotification();
		enterTitleField(title);
		String text=titleField.getText();
		System.out.println(text);
		//clickOnResetButton();
		
		
		if(text.isEmpty())
		{
			return true;

		}
		else
			return false;
	}
	
	public boolean clearDescriptionfieldUsingResetButton(String description)
	{
		clickOnPushNotification();
		clickOnDescriptionField(description);
		System.out.println(descriptionField.getText());
		//clickOnResetButton();
		System.out.println("The text is:"+descriptionField.getText());
		if(descriptionField.getText()==null)
		{
			return false;

		}
		else
			return true;
	}
}
