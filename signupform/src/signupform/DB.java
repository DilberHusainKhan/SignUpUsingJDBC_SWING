package signupform;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	Connection conn = null;
	java.sql.PreparedStatement pst;
	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
			return null;	
		}
	}
}
