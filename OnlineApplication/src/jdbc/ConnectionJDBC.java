package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectionJDBC{
	
	static InputStream inputStream;
	
	public static Connection getPostgresCon(){
		
		
		Properties prop = new Properties();
		String propFileName = "config.properties";
		//InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try{
		inputStream = new FileInputStream(propFileName);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		}catch(Exception e){
		}
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		String database=prop.getProperty("database");
		
		System.out.println("User   "+prop.getProperty("username"));
		
		
		prop.setProperty("user", "postgres");
		prop.setProperty("password", "password");
		prop.setProperty("ssl", "true");
		Connection connection = null;
		//String url = "jdbc:postgresql://localhost:5432;"+"databaseNamepostgres;", "postgres", "password";
		try{
			
			String url = "jdbc:postgresql://localhost:5432/"+database;
			System.out.println("URL "+url);
			Class.forName("org.postgresql.Driver");
			//"jdbc:postgresql://localhost:5432/postgres", "postgres", "password"
			
			connection = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e){
    			e.printStackTrace();
    	}
    		 return connection;
	}
}