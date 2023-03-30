package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		//step1: open the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        
		//Step 2: create object of properties from java.util package
		Properties pObj = new Properties();
		
		//step 3: load the file input stream into properties
		pObj.load(fis);
		
		//step4: access the values with keys
		String URL = pObj.getProperty("url");
		String UserName = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(URL);
		System.out.println(UserName);
		System.out.println(PASSWORD);
	}

}
