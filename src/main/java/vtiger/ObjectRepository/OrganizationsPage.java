package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	//intialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOrgLookUpImg()
	{
		return CreateOrgLookUpImg;
	}

	//Business library
	/**
	 * This method will perform click operation on create org Look up image
	 */
	public void Create_Org()
	{
		CreateOrgLookUpImg.click();
	}

	
}
