package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
     @FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement ContactHeaderText;
     
     public ContactInfoPage(WebDriver driver)  //test Script
 	{
 		PageFactory.initElements(driver, this);
 	}
     
    
    public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

    public String ContactHeader()
    {
    	return ContactHeaderText.getText();
    }

    
 }
