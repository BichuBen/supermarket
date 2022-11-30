package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class Manage_Expense
{
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpensebutton;
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[1]")
	private WebElement ExpenseCategorybutton;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	private WebElement newButton;
	@FindBy(id="name")
	private WebElement titleField;
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath="//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(id="un")
	private WebElement searchtitleField;
	@FindBy(name ="Search")
	private WebElement search_button;
	@FindBy(xpath="//tbody//tr//td[1]")
	private WebElement search_Element;
	
	
	
	
	
	public Manage_Expense(WebDriver driver)
	{
	
			this.driver=driver;
			PageFactory.initElements(driver,this);

	}
	public void clickOnManageExpense()
	{
		manageExpensebutton.click();
	}
	public void clickOnExpenseCategory()
	{
		ExpenseCategorybutton.click();
	}
	public void clickOnNew()
	{
		newButton.click();
	}
	public void enterTitleField(String title)
	{
		generalutilities=new GeneralUtilities(driver);
		String Title=title+generalutilities.get_RandomNo();
		titleField.sendKeys(Title);
	}
	public void clickonSave()
	{
		saveButton.click();
	}
	public void clickOnSearch()
	{
		searchButton.click();
	}
	public void enterSearchTitleField(String searchtitle)
	{
		searchtitleField.sendKeys(searchtitle);
	}
	public void clickOnSearch_Button()
	{
		search_button.click();
	}
	public String addExpenseCategory(String title)
	{
		clickOnManageExpense();
		clickOnExpenseCategory();
		clickOnNew();
		enterTitleField(title);
		clickonSave();
		return successAlert.getText();
		
	}
	
	public String Search(String Searchtitle)
	{
		clickOnManageExpense();
		clickOnExpenseCategory();
		clickOnSearch();
		enterSearchTitleField(Searchtitle);
		clickOnSearch_Button();
		return search_Element.getText();
	}
	
}
