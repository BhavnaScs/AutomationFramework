package Practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = -3) //for enabled this step
	public void createuser()
	{
		System.out.println("create_USER");
	}
	
   @Test()
   public void createUser()
   {
	   System.out.println("create");  //java
   }
   
   @Test(dependsOnMethods = "createUser")
   public void updateUser()
   {
	   System.out.println("update");
   }

   @Test(dependsOnMethods = {"createUser","updateUser"})
   public void deleteUser()
   {
	   System.out.println("delete");
   }
   
   @Test(enabled = false) //for enabled this steps
   public void updateuser()
   {
	   System.out.println("update_user");
   }
}
