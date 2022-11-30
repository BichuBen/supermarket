package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;

public class Login_Page {
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	GeneralUtilities generalutilities;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
	private WebElement SignInButton;
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileownername;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertmessage;
	@FindBy(xpath="//label[@for='remember']")
	private WebElement remembermetext;

	
	

	public Login_Page(WebDriver driver) {
		try {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			ip = new FileInputStream(Constants.CONFIGURE_FILE_PATH);
			prop.load(ip);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void enterUserName(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clickOnSigninButton()
	{
		SignInButton.click();
	}
	
	public void login()
	{
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		login(username, password);
		
	}
	public void login(String username,String password)
	{
		enterUserName(username);
		enterPassword(password);
		clickOnSigninButton();
		
	}
	public String getLoginUserName()
	{
		generalutilities=new GeneralUtilities(driver);
		//System.out.println(profileownername.getText());
		return generalutilities.getTextofElement(profileownername);
		
		
	}
	
	public boolean invalidAlertMessagePresent(String expectedtext)
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.isExpectedTextPresent(alertmessage,expectedtext);
	}
	
	public String getRemembermeText()
	{
		generalutilities=new GeneralUtilities(driver);
		return generalutilities.getTextofElement(remembermetext);
	}
	
	
}
