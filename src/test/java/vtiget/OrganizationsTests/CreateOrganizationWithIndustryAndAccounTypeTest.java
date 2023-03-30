package vtiget.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryAndAccounTypeTest extends BaseClass {
 
	@Test
	public void CreateOrganizationWithIndustryAndAccounType_004() throws EncryptedDocumentException, IOException
	{
		//Step1:
		/*READ DATA FROM EXCEL SHEET*/
		String OrgName = eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
		String IndustryType = eUtil.readDataFromExcel("Organization", 7, 3);
		String AccountType = eUtil.readDataFromExcel("Organization", 7, 4);
		
		//Step 2: click on Organization Link
	    HomePage HP = new HomePage(driver);
	    HP.ClickOnOrganizationLink();
	    
	    //Step 3 : Click on Organization Look Up Image
	    OrganizationsPage OP = new OrganizationsPage(driver);
	    OP.Create_Org();
	    
	    //Step 4 : Create Organization with industry and Account type
	    CreateNewOrganizationPage CO = new CreateNewOrganizationPage(driver);
	    CO.CreateOrganization(OrgName, IndustryType, AccountType);
	    
	    //Step 5: Validate Organization
	    OrganizationsInfoPage OI = new OrganizationsInfoPage(driver);
	     String org_Header = OI.OrgHeader();
	 	Assert.assertTrue(org_Header.contains(OrgName));
		System.out.println("Organization created");
	}
}
