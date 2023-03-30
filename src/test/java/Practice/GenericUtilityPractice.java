package Practice;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
        
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Contacts", 4, 2);
		System.out.println(value);
		
		System.out.println(eUtil.getRowCount("Contacts"));
		
		eUtil.writeDataIntoExcel("Contacts", 4, 8, "superman");
		
		WebDriverUtility wd = new WebDriverUtility();
		wd.maximiseWindow(new ChromeDriver());
		wd.minizeWindow(new ChromeDriver());
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInFormat());
		
	}

}
