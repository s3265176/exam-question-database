package Server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	private Connection con;
	private final String paramFile = "mysql.ini";
	
	public Connection connect(){
		
		
		// set up connection and return connection 
		if(con==null){
			// read database info from mysql.ini
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(paramFile));
			} catch (FileNotFoundException e) {
				
				System.out.println(" can not find file "+ paramFile);
				e.printStackTrace();
			} catch (IOException e) {
				
				System.out.println("unable to read from "+ paramFile);
				e.printStackTrace();
			}
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url , user , pass);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return con;	
			
		}
		else{
			return con;
		}
		
	}
	
	public void closeConn() throws SQLException{
		if (con!= null)con.close();
	}
	
	

}
