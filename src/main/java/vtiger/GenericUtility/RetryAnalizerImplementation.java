package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iretryAnalyser interface of TestNG
 * @author ASUS
 *
 */

public class RetryAnalizerImplementation implements IRetryAnalyzer{

	
	int count = 0;
	int retryCount = 3;
	/**
	 * This method will retry for 3 times
	 */
	
	public boolean retry(ITestResult result) {
		
		while(count< retryCount)
		{
			count++;
			return true; //retry()
		}
	return false ;
	
	}
}
