package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageSlider
{
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-window-restore']")
	private WebElement ManageSlider;
	@FindBy(linkText = "New")
	private WebElement newButton;
	@FindBy(xpath ="//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(id ="link")
	private WebElement linkField;
	@FindBy(name = "create")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement sliderCreateSuccessAlert;
	
	public ManageSlider(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	public void clickOnManageSlider()
	{
		ManageSlider.click();
	}
	
	public void clickOnNew()
	{
		newButton.click();
	}
	
	public void clickOnChooseFile(String imagename)
	{
		generalutilities=new GeneralUtilities(driver);
		generalutilities.fileUploadUsingRobotClass(chooseFile,imagename);
		
	}
	public void enterLinkText(String linktext)
	{
		linkField.sendKeys(linktext);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public String getTextofSliderCreateSuccess()
	{
		
		return sliderCreateSuccessAlert.getText();
	}
	
	public void addSliderNew(String imagename,String linktext)
	{
		clickOnManageSlider();
		clickOnNew();
		clickOnChooseFile(imagename);
		enterLinkText(linktext);
		clickOnSaveButton();
		//getTextofSliderCreateSuccess();
	}
}
