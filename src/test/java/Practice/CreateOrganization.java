package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganization {

	@Test
     public void CreateOrganization_002() throws EncryptedDocumentException, IOException {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		// // Step 1: Read all the necessary Data
		/* Read data from property File - Common Data */
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser"); // chrome, Firefox, edge
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		/* Read data from excel sheet - Test data */
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String OrgName = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+random;

		WebDriver driver = null;

		// Step 2: Launch the browser - runtime polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);


		//Step 3:Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		

		// Step 4:Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 5:Click on create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//step 6 : create organizations with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				

		//step 7: Verification for organization
		String OrganizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrganizationHeader.contains(OrgName))
				{
					System.out.println(OrganizationHeader+" --- PASS ---");
				}
				else
				{
					System.out.println("-- FAIL --");
				}

		//Step 7: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out successfull");


	}

}
