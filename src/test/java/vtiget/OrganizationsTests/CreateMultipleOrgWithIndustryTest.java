package vtiget.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {

	
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String Org, String INDUSTRY)
	{
		String ORGNAME = Org+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganizationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.Create_Org();;
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY);
		
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.OrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.ReadMultipleData("Multiple");
		return data;
	}
}
