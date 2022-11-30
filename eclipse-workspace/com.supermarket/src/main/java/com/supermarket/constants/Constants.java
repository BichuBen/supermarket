package com.supermarket.constants;

public class Constants 
{
public static final String CONFIGURE_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\configure.properties";
public static final String SCREENSHOT_FILE_PATH=System.getProperty("user.dir")+"\\Screenshots\\";
public static final String EXTENT_REPORT=System.getProperty("user.dir")+"\\ExtentReport";
//**Loginpage**//
public static final String expectedRememberMeMsg="Remember Me";


//**PushNotificationPage**//
public static final String EXPECTED_PUSH_NOTIFICATION_SUCCESS_ALERT="×\n"+ "Alert!\n"+ "Message send successfully";


//**searchListPage**//
public static final String EXPECTED_SEARCH_STRING="choclate";

//**Manage Expense Page**//
public static final String EXPECTED_TITLE_CREATION_ALERT="×\n"+ "Alert!\n"+ "Expense Category Created Successfully";
public static final String EXPECTED_SEARCH_ELEMENT="Pistachios";

//**Manage Slider Page**//
public static final String EXPECTED_SLIDER_ALERT_SUCCESS="�\n"+ "Alert!\n"+ "Slider Created Successfully";
}