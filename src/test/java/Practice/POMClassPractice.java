package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {
	
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*lp.getUsernameEdt().sendKeys("admin");
		lp.getpasswordEdt().sendKeys("admin");
		lp.getSubmitBtn().click();
		*/
		WebDriver driver = null;
		
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
		LoginPage lp = new LoginPage(driver);
		
		lp.LoginTOApp(USERNAME, PASSWORD);
		
		
		
		HomePage Hp = new HomePage(driver);
		//Hp.Contact();
		Hp.getContactLink().click();
		
		ContactPage Cp= new ContactPage(driver);
		Cp.clickOnCreateContactImg();
		
		CreateNewContactPage CC= new CreateNewContactPage(driver);
		CC.CreateNewContact("Bhavna");
		
		ContactInfoPage ci = new ContactInfoPage(driver);
		ci.ContactHeader();
		
		
	}
}
