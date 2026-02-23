package hardcoding;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	public static void main(String[] args) throws SQLException {
//	load the db driver
		
	
		
		
		//connect to db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		//step3 create sql statement
		Statement stat=con.createStatement();
		
		//step4: Execute select query and get result
		ResultSet result=stat.executeQuery("select * from tablename");
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		con.close();
		}
		
		
	

	}


