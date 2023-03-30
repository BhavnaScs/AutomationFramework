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

public class CreateOrganizationWithIndustryTest extends BaseClass {
	@Test
	public void createOrganizationWithIndustry_003() throws EncryptedDocumentException, IOException 
	{
		//Step 1 :
		/*Read Data from Excel sheet */
	   String OrgName	= eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
	   String IndustryType = eUtil.readDataFromExcel("Organization", 4, 3);
	   
	   //Step 2: Click on Organization Link 
	   HomePage HP = new HomePage(driver);
	   HP.ClickOnOrganizationLink();
	   
	   //Step 3: Click on OrganizationLookUp Image
	   OrganizationsPage OP = new OrganizationsPage(driver);
	   OP.Create_Org();
	   
	   //step 4: Crete organization with industry
	   CreateNewOrganizationPage CP = new CreateNewOrganizationPage(driver);
	   CP.CreateOrganization(OrgName, IndustryType);
	   
	   //step 5 : validate Organization 
	   OrganizationsInfoPage OI = new OrganizationsInfoPage(driver);
	   String OrgHeader = OI.OrgHeader();
	   Assert.assertTrue(OrgHeader.contains(OrgName));
	   System.out.println(OrgHeader+" Organization created ");
	  
	}
	

}
