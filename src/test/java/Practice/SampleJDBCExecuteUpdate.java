package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		
		//Step 1 : register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2 : get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root","root");
		
        //Step 3 : issue create statement
		Statement state = con.createStatement();
		
		//Step 4 : execute a query
		String query = "insert into candidateinfo values('Alankrita',11,'Sweden');";
	    int result = state.executeUpdate(query);
	    if(result>=1)
	    {
	    	System.out.println("data added");
	    }
	    ResultSet res = state.executeQuery("select * from candidateinfo");
	    while (res.next())
	    {
	    	System.out.println(res.getString(1)+"  "+res.getInt(2)+"  "+res.getString(3));
	    }
	    
		//Step 5 : close the database
	    con.close();
	    System.out.println("db closed");
	}

}
