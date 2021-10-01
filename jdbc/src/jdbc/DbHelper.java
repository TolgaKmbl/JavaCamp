package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private String userName = "userName";
	private String password = "password";
	private String dbUrl = "jdbc:mysql://localhost:port/dbName";
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl,userName,password);
	}

	public void showErrorMessage(SQLException exception) {
		System.out.println("Error "+exception.getMessage());
		System.out.println("Error code "+exception.getErrorCode());
	}
}
