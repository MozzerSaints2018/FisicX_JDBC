package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				/*Objeto do tipo Proporties cont�m as propriedads de conex�o*/
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				/* Vari�vel conn receber� os parametros para conex�o*/
				conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	public static void closeStatement(Statement st) {
		try {
			if(st != null) {
				st.close();
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	public static void closeResultSet(ResultSet res) {
		if(res != null) {
			try {
				res.close();
			}
			catch (SQLException e){
				throw new DbException(e.getMessage());
			}
		}
	}

}
