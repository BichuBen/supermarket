package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.Home_Page;
import com.supermarket.pages.Login_Page;

public class Home_PageTests extends Base
{
	Home_Page Homepage;
	Login_Page loginpage;
	
	@Test(invocationCount = 1,priority = 1)
	public void verifyFirstMenuItemName()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		Homepage=new Home_Page(driver);
		String Actualmenuname=Homepage.First_Menu_Item();
		String Expectedmenuname="Manage Pages";
		Assert.assertEquals(Actualmenuname,Expectedmenuname);
	}
	
	@Test(invocationCount =1,priority = 2)
	public void verifyAdminUsersText()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		Homepage=new Home_Page(driver);
		String actualMenuName=Homepage.AdminUsersText();
		String expectedMenuName="Admin Users";
		Assert.assertEquals(actualMenuName, expectedMenuName);
		
	}
	
	@Test(invocationCount = 1,priority = 3)
	public void verifyCorrectUserLogin()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		Homepage=new Home_Page(driver);
		String actualUser=Homepage.correctUserLogin();
		String expectedUser="Admin";
		Assert.assertEquals(actualUser, expectedUser);
	}
	
	@Test(invocationCount = 1,priority=4)
	public void verifyClickonVerifyUsers()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		Homepage=new Home_Page(driver);
		Homepage.clickOnVerifyUsers();
		String actualUrl=Homepage.clickOnVerifyUsers();
		String expectedUrl="https://groceryapp.uniqassosiates.com/admin/verify-users";
		Assert.assertEquals(actualUrl,expectedUrl);
	}
}
