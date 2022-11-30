package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;

public class Home_Page
{

	WebDriver driver;
	GeneralUtilities generalutilities=new GeneralUtilities(driver);
	
	@FindBy(xpath="(//div[@class='inner']//following-sibling::p)[1]")
	private WebElement managepages;
	@FindBy(xpath ="(//div[@class='inner']//following-sibling::p)[2]")
	private WebElement AdminUsers;
	@FindBy(linkText ="Admin")
	private WebElement Admin;
	@FindBy(linkText = "Verify Users")
	private WebElement verifyUsers;
	
	
	public Home_Page(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	
	public String First_Menu_Item()
	{
		return generalutilities.getTextofElement(managepages);
	}
	
	public String AdminUsersText()
	{
		return generalutilities.getTextofElement(AdminUsers);
	}
	
	public String correctUserLogin()
	{
		return generalutilities.getTextofElement(Admin);
	}
	
	public String clickOnVerifyUsers()
	{
		
		verifyUsers.click();
		return driver.getCurrentUrl();
	}
}
