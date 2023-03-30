package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author Bhavna
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
  
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	    Properties pObj = new Properties();
	    pObj.load(fis);
	    String value = pObj.getProperty(key);
	    return value;
	 }
	
}
