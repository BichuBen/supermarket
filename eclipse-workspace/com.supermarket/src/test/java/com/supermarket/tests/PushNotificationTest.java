package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.Login_Page;
import com.supermarket.pages.PushNotificationPage;

public class PushNotificationTest extends Base
{
	Login_Page loginpage;
	PushNotificationPage pushnotificationpage;
	Constants constants;
	
	@Test
	public void verifyPushNotificationFunctionality()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		String actualalert=pushnotificationpage.verifyPushNotoficationSuccessAlert("This is sample Title","This is sample description");
		Assert.assertEquals(actualalert,constants.EXPECTED_PUSH_NOTIFICATION_SUCCESS_ALERT);
	}
	@Test
	public void verify_clear_Titlefield_UsingResetButton_functionality()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.clearTitlefieldUsingResetButton("This is Sample Title");
	}
	
	@Test
	public void verify_clear_DescriptionField_UsingResetButton_functionality()
	{
		loginpage=new Login_Page(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		//pushnotificationpage.clearDescriptionfieldUsingResetButton("This is Sample Description");
		Assert.assertTrue(pushnotificationpage.clearTitlefieldUsingResetButton("this is sample"));
	}
}
