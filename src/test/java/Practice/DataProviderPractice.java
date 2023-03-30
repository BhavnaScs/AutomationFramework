package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	
	@Test(dataProvider = "electronics")
	public void dataproviderpractce(String phone , int price)
	{
		System.out.println(phone+ " ----  "+price);
	}

	@DataProvider(name = "phone")
	public Object[][] getData()
	{                               //row //column
		Object[][] data = new Object[3][2] ;//3 set of data each consist of 2 info
		
		data[0][0] ="Samsung";	
		data [0][1] = 1200;
		
		data[1][0] = "Iphone";
		data[1][1]= 1000;
		
		data[2][0]="Nokia";
		data[2][1]= 700;
		
		return data;
	}
	
	@DataProvider(name = "electronics")
	public Object[][] getData1()
	{
	Object[][] data = new Object[3][0]; //3 sets of data each consists odf 1 info
	
	data [0][0] ="samsung";
	
	data [1][0]="Iphone";
	
	data [2][0]="Nokia";
	
	return data;
	}



}
