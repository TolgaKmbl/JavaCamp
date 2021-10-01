package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws SQLException {
		
	}
	
	public static void selectDemo() throws SQLException {
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		Statement statement = null;
		ResultSet resultSet;
		try {			
			connection = dbHelper.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
			ArrayList<Country> countries = new ArrayList<Country>();
			while(resultSet.next()) {
				countries.add(new Country(
						resultSet.getString("Code"), 
						resultSet.getString("Name"), 
						resultSet.getString("Continent"), 
						resultSet.getString("Region")));
			}
			System.out.println(countries.size());		
			
		} catch(SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			connection.close();
		}
	}
	
	public static void insertDemo() throws SQLException {
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		PreparedStatement statement = null;
		ResultSet resultSet;
		try {			
			connection = dbHelper.getConnection();
			String sql = "insert into city (Name,CountryCode,District,Population) values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "Düzce 3");
			statement.setString(2, "TUR"); 
			statement.setString(3, "Turkey");
			statement.setInt(4, 45000);
			int result = statement.executeUpdate();
			System.out.println("Kayýt eklendi");
			
		} catch(SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	public static void updateDemo() throws SQLException {
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		PreparedStatement statement = null;
		ResultSet resultSet;
		try {			
			connection = dbHelper.getConnection();
			String sql = "update city set population = 80001, district = 'Düzce' where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 4082);
			int result = statement.executeUpdate();
			System.out.println("Kayýt güncellendi");
			
		} catch(SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	public static void deleteDemo() throws SQLException {
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		PreparedStatement statement = null;
		ResultSet resultSet;
		try {			
			connection = dbHelper.getConnection();
			String sql = "delete from city where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 4082);
			int result = statement.executeUpdate();
			System.out.println("Kayýt silindi");
			
		} catch(SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			statement.close();
			connection.close();
		}
	}

}
