package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage{

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationsInfoPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrgHeader()
	{
		return OrgHeaderText;
	}
	
	/**
	 * This method will capture the text from org Header and return it to caller
	 * @return
	 */
	
	public String OrgHeader()
	{
		return OrgHeaderText.getText();
	}
}
