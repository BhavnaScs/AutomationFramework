package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnaliserPractice {
  
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalizerImplementation.class)
	public void practice()
	{
		Assert.fail();
		System.out.println("--");
	}
}
