package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class Admin_Users 
{
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(id ="username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(name="user_type")
	private WebElement usertypebutton;
	@FindBy(name="Create")
	private WebElement savebutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchbutton;
	@FindBy(id="un")
	private WebElement searchUserNameField;
	@FindBy(id="ut")
	private WebElement searchUserType;
	@FindBy(name="Search")
	private WebElement search;
	@FindBy(name="Update")
	private WebElement updatebutton;
	
	
	public Admin_Users(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	
	public void clickOnAdminUsers()
	{
		adminuser.click();
	}
	
	public void clickOnNew()
	{
		newbutton.click();
	}
	
	public void enterUserName(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clickOnUserType()
	{
		usertypebutton.click();
	}
	
	public void clickOnSave()
	{
		savebutton.click();
	}
	
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	
	public void enterSearchUserName(String username)
	{
		searchUserNameField.sendKeys(username);
	}
	
	public void search()
	{
		search.click();
	}
	
	public void update()
	{
		updatebutton.click();
	}

	
	
	public void selectUserType(WebElement element,String user)
	{
		pageutility=new PageUtility(driver);
		if("Staff"==user)
		{
			pageutility.selectByIndex(element, 1);
		}
		else if("Admin"==user)
		{
			pageutility.selectByIndex(element, 2);
		}
		
		else if("Partner"==user)
		{
			pageutility.selectByIndex(element, 3);
		}
		
		else if("Delivery Boy"==user)
		{
			pageutility.selectByIndex(element, 4);
		}
	}
	
	public void createNewUser(String username,String password,String usertype)
	{
		generalutilities=new GeneralUtilities(driver);
		clickOnAdminUsers();
		clickOnNew();
		String name=username+generalutilities.get_RandomNo();
		enterUserName(name);
		enterPassword(password);
		clickOnUserType();
		selectUserType(usertypebutton, usertype);
		clickOnSave();
		
	}
	
	public void searchUser(String username,String usertype)
	{
		clickOnAdminUsers();
		clickOnSearchButton();
		enterSearchUserName(username);
		selectUserType(searchUserType,usertype);
		search();
		
	}
	
	public void edituser(String userName)
	{
		clickOnAdminUsers();
		generalutilities = new GeneralUtilities(driver);
		List<String> names = new ArrayList<String>();
		names = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < names.size(); pos++)
		{
			if (names.get(pos).equals(userName))
			{
				pos++;
				break;
			}

		}
		WebElement editUser = driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[2]"));
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(editUser);
		update();
	
	}
	
	public void deactivateuser(String username)
	{
		clickOnAdminUsers();
		generalutilities = new GeneralUtilities(driver);
		List<String> names = new ArrayList<String>();
		names = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < names.size(); pos++)
		{
			if (names.get(pos).equals(username))
			{
				pos++;
				break;
			}

		}
		WebElement deactivateUser = driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[1]"));
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(deactivateUser);
	}
	
	public void deleteUser(String userName)
	{
		clickOnAdminUsers();
		generalutilities = new GeneralUtilities(driver);
		List<String> names = new ArrayList<String>();
		names = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < names.size(); pos++)
		{
			if (names.get(pos).equals(userName))
			{
				pos++;
				break;
			}

		}
		WebElement deleteUser = driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[3]"));
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(deleteUser);
		
	}
}
