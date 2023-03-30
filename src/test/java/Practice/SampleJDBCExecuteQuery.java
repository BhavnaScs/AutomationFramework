package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


import java.sql.Statement;



public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		//driver for mysql database
		Driver driverRef = new Driver();
		
		//step1: register the driver
		 DriverManager.registerDriver(driverRef);
		
		//step2: get the connection from datatbase
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root","root");
		
		//step3: issue the create statement
		Statement state = con.createStatement();
		
		
		//step4: execute a query
		ResultSet result = state.executeQuery("Select * from candidateinfo;");
		while(result.next()) {
			System.out.println(result.getString(1) + "     "+ result.getInt(2)+"    "+result.getString(3));
		}
		//step5: close the database
		con.close();
		System.out.println("db closed");

	}

}
