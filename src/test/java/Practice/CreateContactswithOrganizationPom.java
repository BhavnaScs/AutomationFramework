package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactswithOrganizationPom {
	
	@Test
	public void VT_003_CreateContactsWithOrganization() throws IOException {
		

				// Step 1: Create Object for all utilities
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				JavaUtility jUtil = new JavaUtility();

				// Step 2: Read all the necessary Data
				/* Read data from property File - Common Data */
				String URL = pUtil.readDataFromPropertyFile("url");
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");

				/* Read data from excel sheet - Test data */
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);

				WebDriver driver = null;

				// Step 2: Launch the browser - runtime polymorphism
				if (BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					System.out.println("Invalid Browser name");
				}

				wUtil.maximiseWindow(driver);
				wUtil.waitForPage(driver);
				driver.get(URL);

				// Step 3: Login to App
				LoginPage lp = new LoginPage(driver);
				lp.LoginTOApp(USERNAME, PASSWORD);
						
				// Step 4: Click on Organizations link
				HomePage hp = new HomePage(driver);
				hp.ClickOnOrganizationLink();
				
				// Step 5: Click on Create Organization look up image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.Create_Org();

				// Step 6: Create Organization with mandatory details
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME);

				// Step 8: Validate for Organization
				OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
				String orgHeader = oip.OrgHeader();
				
				if (orgHeader.contains(ORGNAME)) {
					System.out.println(orgHeader + "Organizationm created");
				} else {
					System.out.println("Organization not created");
				}

				// Step 9: Navigate to contacts Link
				hp.ClickOnContactsLink();

				// Step 10:Click on create contact look up image
				ContactPage cp = new ContactPage(driver);
				cp.clickOnCreateContactImg();

				// Step 11: Create contact with mandatory fields and save
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
			
				// Step 16: Validate for Contacts
				ContactInfoPage cip = new ContactInfoPage(driver);
				String ContactHeader = cip.ContactHeader();
			
				if(ContactHeader.contains(LASTNAME))
				{
					System.out.println(ContactHeader+" --- PASS ---");
				}
				else
				{
					System.out.println("-- FAIL --");
				}
				
				//Step 17: Logout of Application
				hp.LogoutOfApp(driver);
				System.out.println("Sign out successfull");
				                             		
	}

}
