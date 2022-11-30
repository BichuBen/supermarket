package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManagePages 
{
	
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	private WebElement manageContent;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[1]")
	private WebElement managePages;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	private WebElement newbutton;
	@FindBy(id="title")
	private WebElement titleField;
	@FindBy(xpath="//div[@class='note-editable card-block']")
	private WebElement descriptionField;
	@FindBy(id="page")
	private WebElement enterpagename;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath="//i[@class=' fa fa-search']")
	private WebElement searchbutton;
	@FindBy(name ="un")
	private WebElement searchTitleField;
	@FindBy(xpath ="//button[@value='sr']")
	private WebElement search_Button;
	@FindBy(xpath ="//tbody//tr//td[1]")
	private WebElement search_key;
	
	
	
	
	
	public ManagePages(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	
	public void clickOnManageContent()
	{
		manageContent.click();
	}
	
	public void clickOnManagePages()
	{
		managePages.click();
	}
	
	public void clickOnNew()
	{
		newbutton.click();
	}
	
	public void entertitleField(String title)
	{
		titleField.sendKeys(title);
	}
	
	public void enterdescriptionField(String description)
	{
		descriptionField.sendKeys(description);
	}
	
	public void enterPageName()
	{
		generalutilities=new GeneralUtilities(driver);
		enterpagename.sendKeys(generalutilities.get_RandomNo());
	}
	
	public void clickOnSaveButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}
	public void clickOnSearch()
	{
		searchbutton.click();
	}
	
	public void enterSearchTitleField()
	{
		searchTitleField.sendKeys("choclate");
	}
	
	public void clickOnSearch_Button()
	{
		search_Button.click();
	}
	public void addPages(String title,String description,String imagename)
	{
		
		clickOnManageContent();
		clickOnManagePages();
		clickOnNew();
		entertitleField(title);
		enterdescriptionField(description);
		enterPageName();
		chooseFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\ImageFiles\\"+imagename);
		clickOnSaveButton();
		
	}
	public String searchTitleInListPages()
	{
		clickOnManageContent();
		clickOnManagePages();
		clickOnSearch();
		enterSearchTitleField();
		clickOnSearch_Button();
		return search_key.getText();
	}
	
	
}
