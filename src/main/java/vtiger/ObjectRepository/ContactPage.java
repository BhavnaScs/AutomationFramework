package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateHeaderText;
	
	
	//intialization
	public ContactPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateHeaderText() {
		return CreateHeaderText;
	}
	
	//Business Library
	/**
	 * THis method will perform click operation on create contact look up image
	 */
	public void clickOnCreateContactImg()
	{
		CreateHeaderText.click();
	}
	
}
