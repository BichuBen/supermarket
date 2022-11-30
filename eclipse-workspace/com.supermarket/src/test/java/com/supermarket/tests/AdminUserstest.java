package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.Admin_Users;
import com.supermarket.pages.Login_Page;

public class AdminUserstest extends Base
{
	
	Login_Page loginpage;
	Admin_Users adminusers;
	
	
	@Test
	public void verifyCreateUser()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		adminusers=new Admin_Users(driver);
		adminusers.createNewUser("Aleeshya","Aleeshya","Admin");
		
		
	}
	@Test
	public void verifySearchUser()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		adminusers=new Admin_Users(driver);
		adminusers.searchUser("meerameera","Staff");
		
	}
	
	@Test
	public void verifyEditUser()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		adminusers=new Admin_Users(driver);
		adminusers.edituser("Aleeshya8");
		
	}
	
	@Test
	public void verifyDeactivateUser()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		adminusers=new Admin_Users(driver);
		adminusers.deactivateuser("Aleeshya8");
	}
	
	@Test
	public void verifyDeleteUser()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		adminusers=new Admin_Users(driver);
		adminusers.deleteUser("johny6");
	}
	

	
	
}
