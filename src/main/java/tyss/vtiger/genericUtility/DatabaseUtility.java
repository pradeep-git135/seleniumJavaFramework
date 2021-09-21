package tyss.vtiger.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Driver driverRef;
	Connection con;
	Statement st;
	ResultSet result;
    public void connectDB() throws Throwable {
    	DriverManager.registerDriver(driverRef);
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
    	st = con.createStatement();
    }
    
    public String getDataFromDB(String query, int columnIndex) throws Throwable {
    	String value = null;
    	result = st.executeQuery(query);
    	while (result.next()) {
    		value = result.getString(columnIndex);
		}
    	return value;
    }
    
}
