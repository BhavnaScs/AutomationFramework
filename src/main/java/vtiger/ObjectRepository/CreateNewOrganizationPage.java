package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement TypeDropDown;
    
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgName()
	{
		return OrgName;
	}
	
	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
    
	/**
	 * THids method will create organization with OrgName
	 * @param Org_Name
	 */
	public void createOrganization(String Org_Name)
	{
		OrgName.sendKeys(Org_Name);
		SaveBtn.click();
	}
	 
	/**
	 * This method will create Organization with IndustryType
	 * @param Org_Name
	 * @param industryType
	 */
	
	public void CreateOrganization(String Org_Name, String industryType)
	{
		OrgName .sendKeys(Org_Name);
		handleDropdown(IndustryDropDown, industryType);
	    SaveBtn.click();
	  
	}

	/**
	 * This method will Create organization with industry and account type
	 * @param Org_Name
	 * @param industryType
	 * @param AccountName
	 */
    public void CreateOrganization(String Org_Name, String industryType , String AccountName)
    {
    	OrgName.sendKeys(Org_Name);
    	handleDropdown(IndustryDropDown,industryType );
    	handleDropdown(TypeDropDown, AccountName);
    	SaveBtn.click();
    }

}
