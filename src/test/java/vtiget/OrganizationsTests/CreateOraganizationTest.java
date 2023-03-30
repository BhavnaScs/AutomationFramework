package vtiget.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenerImplimentation.class)
public class CreateOraganizationTest  extends BaseClass {

	
	@Test
	public void createOrganizationWithMAndatoryFields_002() throws EncryptedDocumentException, IOException {
		//Step 1:
		/* Read Data From excel */
		String OrgName = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 2:Click on Organization link 
		HomePage HP = new HomePage(driver);
		HP.ClickOnOrganizationLink();
		
		//Step3: Click on Organization look up image
		OrganizationsPage OP = new OrganizationsPage(driver);
		OP.Create_Org();
		
		//Step 4 : Create organization with Mandagtory Field
		CreateNewOrganizationPage CN = new CreateNewOrganizationPage(driver);
		CN.createOrganization(OrgName);
	
		//Step 5: Validate Organization 
		OrganizationsInfoPage OI = new OrganizationsInfoPage(driver);
		String ORName = OI.OrgHeader();
		
		Assert.assertTrue(ORName.contains(OrgName));
		System.out.println("Organization created");
		
		
}
	@Test
	public void demoScript()
	{
		System.out.println("DEMO");
	
	}
	
	
	   @Test
	   public void regional()
	   {
		   System.out.println("Regional Regression");
	   }
	
}
