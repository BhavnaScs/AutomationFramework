package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

public class Create_ContactsWithMandatoryFieldsTest  extends BaseClass{
	
	
	@Test
	public void createContactTEST() throws EncryptedDocumentException, IOException
	{
		//Step1
		/* Read data from excel sheet - Test data */
		String LastName = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 2 : Click on Contacts Link
		
		HomePage HP = new HomePage(driver);
		HP.ClickOnContactsLink();
		Reporter.log("Succesfully Click on Contacts Link");
		
		//Step 3 : Click on Contacts look up image
		ContactPage CP = new ContactPage(driver);
		CP.clickOnCreateContactImg();
		Reporter.log("Succesfully Click on Contacts  look up image");
		
		//Step 4: Create contact with mandatory fields and save
		CreateNewContactPage CN = new CreateNewContactPage(driver);
		CN.CreateNewContact(LastName);
		Reporter.log("Succesfully Contact created");
		 
		//Step 5 :  Validate for Contacts
		ContactInfoPage CI = new ContactInfoPage(driver);
		String ContactHeader = CI.ContactHeader();
	    Assert.assertTrue(ContactHeader.contains(LastName));
		System.out.println(ContactHeader+" --- Contact created ");
	}

}
