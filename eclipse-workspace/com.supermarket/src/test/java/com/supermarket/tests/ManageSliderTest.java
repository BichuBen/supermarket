package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.Login_Page;
import com.supermarket.pages.ManageSlider;
import com.supermarket.pages.PushNotificationPage;

public class ManageSliderTest extends Base
{
	Login_Page loginpage;
	PushNotificationPage pushnotificationpage;
	ManageSlider manageslider;
	
	@Test(invocationCount = 1,priority = 1)
	public void verifyAddSliderNewFunctionality()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		manageslider=new ManageSlider(driver);
		manageslider.addSliderNew("lotus.jpeg","www.google.com");
		Assert.assertEquals(manageslider.getTextofSliderCreateSuccess(),Constants.EXPECTED_SLIDER_ALERT_SUCCESS);
	}
}
