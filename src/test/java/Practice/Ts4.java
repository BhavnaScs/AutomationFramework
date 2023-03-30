package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Ts4 {
	public static void main(String[] args) {
        //Step 1: Launch the browser
        
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3:Navigate to organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4:Click on create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5 : create organizations with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("amd");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 6: Select "Chemicals" in the industry drop down
		WebElement ele = driver.findElement(By.name("industry"));
		Select s = new Select(ele);
		s.selectByValue("Energy");
		
		//step7: Select "Customer" in the Type Drop down 
		WebElement ele2 = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(ele2);
		s1.selectByValue("Customer");
		
		
		//step 8: Verification for organization
		String OrganizationHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrganizationHeader.contains("amd"))
		{
			System.out.println(OrganizationHeader+" --- PASS ---");
		}
		else
		{
			System.out.println("-- FAIL --");
		}
		
		//Step 9: Logout of Application
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfull");
		
		

	}
	}


