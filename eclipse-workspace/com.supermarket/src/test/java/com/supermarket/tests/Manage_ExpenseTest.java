package com.supermarket.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.Login_Page;
import com.supermarket.pages.Manage_Expense;

public class Manage_ExpenseTest extends Base
{

	Login_Page loginpage;
	Manage_Expense manageexpense;
	
	@Test
	public void verifyaddExpenseCategory()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		manageexpense=new Manage_Expense(driver);
		Assert.assertEquals(manageexpense.addExpenseCategory("Cashew"),Constants.EXPECTED_TITLE_CREATION_ALERT);
	}
	
	@Test
	public void verifySearchFunctionality()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		manageexpense=new Manage_Expense(driver);
		Assert.assertEquals(manageexpense.Search("Pistachios"),Constants.EXPECTED_SEARCH_ELEMENT);
	}
}
