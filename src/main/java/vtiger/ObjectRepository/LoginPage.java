package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bhavna
 *
 */

public class LoginPage {
	//Rule 1: create a pom class for every web page
	
	//Rule 2: identify the web elements with @findBy, @findall and finBYs
	@FindBy(name = "user_name")
	private WebElement UsernameEdt;
	
	@FindAll({@FindBy(name ="user_password"), @FindBy(xpath="//input[@type='password'")})
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
	
	//Rule 3 : create a constructor to intialise these web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 : provide getters to acess these elements
	public WebElement getUsernameEdt()
	{
		return UsernameEdt;
	}
	
	public WebElement getpasswordEdt()
	{
		return passwordEdt;
	
	}
	
	public WebElement getSubmitBtn()
	{
		return SubmitBtn;
	}

	//Business Libraries - generic methods specific to current project
	public void LoginTOApp(String Username, String Password)
	{
		UsernameEdt.sendKeys(Username);
		passwordEdt.sendKeys(Password);
		SubmitBtn.click();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

