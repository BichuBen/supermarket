package com.supermarket.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviders 
{
WebDriver driver;
@DataProvider(name="deliveryBoyDetails")
public Object[][] delivery_Boy_Details()
{
	return new Object[][] {{"Alluz","8907821434"}};
}

}
