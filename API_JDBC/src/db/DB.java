package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//Implementação da conexão com BD
public class DB {
	
	//Método que conecta o BD
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				connection = DriverManager.getConnection(url, properties);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return connection;
	}
	
	//Método para fechar a conexão
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//Método que carrega as propriedades do "db.properties" e guarda em obj especifico 
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties properties = new Properties();
			properties.load(fs);
			return properties;
		}
		catch(IOException e  ) {
			throw new DbException(e.getMessage());
		}
	}
	
	//Método para fechar o Statement
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	//Método para fechar o ResultSet
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	
}
	}
