package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


public class CreateContactWithOrganizationTest extends BaseClass{
	    
		@Test(groups = "SmokeSuite")
		public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
		{

			/* Read data from excel sheet - Test data */
			String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
					
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
		    String  orgHeader = oip.OrgHeader();
			
		    Assert.assertTrue(orgHeader.contains(ORGNAME));
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
		
           Assert.assertTrue(ContactHeader.contains(LASTNAME));
			
			System.out.println(ContactHeader+" --- Contact created ");
			
		}

	}

	

