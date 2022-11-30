package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.Login_Page;
import com.supermarket.pages.ManagePages;

public class ManagePagesTest extends Base
{
	
	Login_Page loginpage;
	ManagePages managepages;
	
	
	@Test(groups = "Regression")
	public void verifyAddPages()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		managepages=new ManagePages(driver);
		managepages.addPages("This is sample Title","This is sample description","macroni.jpeg");
		
	}
	@Test
	public void verifysearchTitleInListPages()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		managepages=new ManagePages(driver);
		managepages.searchTitleInListPages();
		Assert.assertEquals(Constants.EXPECTED_SEARCH_STRING,managepages.searchTitleInListPages());;
	}

}
