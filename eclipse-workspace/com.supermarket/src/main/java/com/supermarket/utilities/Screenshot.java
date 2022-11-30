package com.supermarket.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.supermarket.constants.Constants;

public class Screenshot 
{
TakesScreenshot scrshot;
GeneralUtilities generalutilities=new GeneralUtilities();


	public void TakeScreenshot(WebDriver driver,String ImageName)
	{
		try
			{
			scrshot=(TakesScreenshot) driver;
			File screen_shot=scrshot.getScreenshotAs(OutputType.FILE);
			String timestamp=generalutilities.get_TimeStamp();
			String DestinationFolder=Constants.SCREENSHOT_FILE_PATH+ImageName+timestamp+".png";
			File finalDestination=new File(DestinationFolder);
			FileHandler.copy(screen_shot, finalDestination);
			}
		
		catch (Exception e)
			{
				e.printStackTrace();
			}
		
	}
}
