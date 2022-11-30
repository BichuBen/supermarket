package com.supermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WeightUtility;

public class ManageDeliveryBoy{
	WebDriver driver;
	GeneralUtilities generalutilities=new GeneralUtilities(driver);
	PageUtility pageutility;

	@FindBy(linkText ="Manage Delivery Boy")
	WebElement ManageDeliveryBoyButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "name")
	WebElement nameField;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id="phone")
	WebElement PhoneNo;
	@FindBy(id = "username")
	WebElement usernameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createNewSuccessAlert;
	@FindBy(linkText = "Cancel")
	WebElement CancelButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement searchUsername;
	@FindBy(name = "Search")
	WebElement Search;
	@FindBy(xpath="//tbody//tr//td[1]")
	WebElement searchResult;

	
	String name1=generalutilities.get_RandomNo();
	

	public ManageDeliveryBoy(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliveryBoy()
	{
		ManageDeliveryBoyButton.click();
	}
	
	public void clickOnNew()
	{
		newButton.click();
	}
	public void enterNameField(String name)
	{
		
		nameField.sendKeys(name+name1);
	}
	
	public void enterEmailField(String name)
	{
		emailField.sendKeys(name+name1+"@gmail.com");
	}
	public void enterPhNo(String Phno)
	{
		PhoneNo.sendKeys(Phno);
	}
	public void enterUserNameField(String name)
	{
		usernameField.sendKeys(name+name1);
	}
	public void enterPassword(String name)
	{
		passwordField.sendKeys(name+name1);
	}
	public void clickOnSaveButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);

	}
	public boolean createNewSuccessAlert()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.is_Displayed(createNewSuccessAlert);
	}
	
	public void clickOnCancelButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(CancelButton);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void enterSearchUserName(String searchname)
	{
		searchUsername.sendKeys(searchname);
	}
	
	public void clickOnSearch()
	{
		Search.click();
	}
	public void createNewDeliveryBoy(String name,String Phno)
	{
		clickOnManageDeliveryBoy();
		clickOnNew();
		enterNameField(name);
		enterEmailField(name);
		enterPhNo(Phno);
		enterUserNameField(name);
		enterPassword(name);
		clickOnSaveButton();
		
		
		
	}
	public String cancelButtonchecking(String name,String Phno)
	{
		clickOnManageDeliveryBoy();
		clickOnNew();
		enterNameField(name);
		enterEmailField(name);
		enterPhNo(Phno);
		enterUserNameField(name);
		enterPassword(name);
		clickOnCancelButton();
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.getCurrenturl();
	}
	
	public String searchUsingname(String searchname)
	{
		clickOnManageDeliveryBoy();
		clickOnSearchButton();
		enterSearchUserName(searchname);
		clickOnSearch();
		return searchResult.getText();
		
	}

}