package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunities;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	
	//intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getContactLink() {
		return ContactLink;
	}


	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}


	public WebElement getOpportunities() {
		return Opportunities;
	}


	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}


	public WebElement getSignOutLink() {
		return SignOutLink;
	}

   //BUsiness Library
	public void ClickOnOrganizationLink() {
		 OrganizationLink.click();
	}
	 public void ClickOnContactsLink() {
		 ContactLink.click();
	 }
	public void LogoutOfApp(WebDriver driver) {
		mouseHoverAction(driver,AdministratorImg );
		SignOutLink.click();
		
	}

}
