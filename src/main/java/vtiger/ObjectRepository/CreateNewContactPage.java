package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	//initilization
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}



	public WebElement getSaveBtn() {
		return SaveBtn;
	}



	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}



	public WebElement getSearchEdt() {
		return searchEdt;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
	/**
	 * this method will create new contacct with lastname
	 * @param Name
	 */
	public void CreateNewContact(String Name)
	{
		LastNameEdt.sendKeys(Name);
		SaveBtn.click();
	}
	
	/**
	 * This Method will create Contact with Organization
	 * @param driver
	 * @param LastName
	 * @param OrgName
	 */
	public void createNewContact(WebDriver driver, String LastName , String OrgName)
	{
		LastNameEdt.sendKeys(LastName);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
}
