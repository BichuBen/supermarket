package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviders;
import com.supermarket.pages.Login_Page;
import com.supermarket.pages.ManageDeliveryBoy;

public class ManageDeliveryBoyTest extends Base
{
	Login_Page loginpage;
	ManageDeliveryBoy managedeliveryboy;
	
	@Test(dataProvider = "deliveryBoyDetails", dataProviderClass = DataProviders.class,invocationCount = 1,priority = 2)
	public void verifyCreateNewDeliveryBoy(String name,String Phno) 
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		managedeliveryboy=new ManageDeliveryBoy(driver);
		managedeliveryboy.createNewDeliveryBoy(name,Phno);
		Assert.assertTrue(managedeliveryboy.createNewSuccessAlert());
		
	}
	
	@Test(invocationCount = 1,priority = 1)
	public void verifyCancelButtonChecking()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		managedeliveryboy=new ManageDeliveryBoy(driver);
		managedeliveryboy.cancelButtonchecking("Abhijith","8089630241");
		Assert.assertEquals(managedeliveryboy.cancelButtonchecking("Abhijith","8089630241"),"https://groceryapp.uniqassosiates.com/admin/list-deliveryboy");
	}
	
	@Test(invocationCount = 1,priority = 1)
	public void verifySearchUsingName()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		managedeliveryboy=new ManageDeliveryBoy(driver);
		Assert.assertEquals(managedeliveryboy.searchUsingname("Arun"),"Arun");
	}
}
