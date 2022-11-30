package com.supermarket.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.Login_Page;
import com.supermarket.utilities.Excel;

public class LoginTest extends Base
{
	Login_Page loginpage;
	Excel excel=new Excel();
@Test(groups = "Smoke")
public void verifylogin()
{
	String username="nasrin";
	String password="nasrin";
	String expectedusername="Nasrin";
	loginpage=new Login_Page(driver);
	//loginpage.login();
	loginpage.login(username, password);
	loginpage.getLoginUserName();
	String actualusername=loginpage.getLoginUserName();
	Assert.assertEquals(actualusername,expectedusername);
	
	
	
}
@Test(groups = {"Smoke","Regression"})
public void verifyStafLoginFunctionality()
{
	loginpage=new Login_Page(driver);
	excel.setExcelFile("Logindata","ValidLoginCredentials");
	String userName=excel.getCelldata(0, 0);
	String password=excel.getCelldata(0, 1);
	
	loginpage.login(userName, password);

}

@Test(groups = "Smoke")
public void verifyInvalidloginAlertMessage()
{
	Login_Page loginpage = new Login_Page(driver);
	excel.setExcelFile("Logindata", "InvalidLoginCredentials");
	String userName = excel.getCelldata(0, 0);
	String password = excel.getCelldata(0, 1);
	loginpage.login(userName, password);
	Assert.assertTrue(loginpage.invalidAlertMessagePresent("Invalid Username/Password"));
	
}


@Test(groups = {"Smoke","Regression"})
public void VerifyRememberMeCheckBoxText()
{
	loginpage=new Login_Page(driver);
	String expectedMessage=Constants.expectedRememberMeMsg;
	String actualMessage=loginpage.getRemembermeText();
	Assert.assertEquals(expectedMessage,actualMessage);
}


}
