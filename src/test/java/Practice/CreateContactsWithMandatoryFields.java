package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;

import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreateContactsWithMandatoryFields {

	
	@Test
	public void VT_001_CreateContactsWithMandatoryFields() throws IOException
	{
		//Step1:Create Object for all utilities
		 ExcelFileUtility eutil = new ExcelFileUtility();
		
		 PropertyFileUtility putil = new PropertyFileUtility();
		 WebDriverUtility wutil = new WebDriverUtility();
		 
	
		// Step 2: Read all the necessary Data
		/* Read data from property File - Common Data */
		 String URL = putil.readDataFromPropertyFile("url");
		 String Browser = putil.readDataFromPropertyFile("browser");
		 String UserName = putil.readDataFromPropertyFile("username");
		 String Password = putil.readDataFromPropertyFile("password");
		 
		/* Read data from excel sheet - Test data */
		 String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2);
		 
		 WebDriver driver = null;
		// Step 2: Launch the browser - runtime polymorphism
		 if (Browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid Browser name");
			}

			wutil.maximiseWindow(driver);
			wutil.waitForPage(driver);
			driver.get(URL);

		// Step 3: Login to App
			LoginPage LP = new LoginPage(driver);
			LP.LoginTOApp(UserName, Password);
				
		// Step 4: Navigate to contacts Link
			HomePage HP = new HomePage(driver);
			HP.ClickOnContactsLink();
			
		//Step 5:Click on create contact look up image
			ContactPage CP = new ContactPage(driver);
			CP.clickOnCreateContactImg();
			
		//Step 6:Create contact with mandatory fields and save
			CreateNewContactPage CN = new CreateNewContactPage(driver);
			CN.CreateNewContact(LASTNAME);
			
		//Step 7: Verification for contact
			ContactInfoPage CIP =new ContactInfoPage(driver);
			String ContactHeader =CIP.ContactHeader();
			
			if(ContactHeader.contains(LASTNAME))
			{
				System.out.println(ContactHeader+" Pass ");
			}
			else
			{
				System.out.println(" Fail ");
			}
			
			//Step 7: Logout of Application
             HP.LogoutOfApp(driver);
             System.out.println("Sign out successfully");
			
			
				
	}
}
