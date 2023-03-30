package vtiger.ContactsTests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class CreateContactsWithmandatoryfieldTest extends BaseClass{
    	@Test(groups = "SmokeSuite")
		public void createConTEST() throws EncryptedDocumentException, IOException
		{
			//Step1
			/* Read data from excel sheet - Test data */
			String LastName = eUtil.readDataFromExcel("Contacts", 4, 3);
			
			//Step 2 : Click on Contacts Link
			HomePage HP = new HomePage(driver);
			HP.ClickOnContactsLink();
			
			//Step 3 : Click on Contacts look up image
			ContactPage CP = new ContactPage(driver);
			CP.clickOnCreateContactImg();
			
			//Step 4: Create contact with mandatory fields and save
			CreateNewContactPage CN = new CreateNewContactPage(driver);
			CN.CreateNewContact(LastName);
			
			//Step 5 :  Validate for Contacts
			ContactInfoPage CI = new ContactInfoPage(driver);
			String ContactHeader = CI.ContactHeader();
			Assert.assertTrue(ContactHeader.contains(LastName));
			System.out.println(ContactHeader+" --- Contact created ");
			
		}

	}


