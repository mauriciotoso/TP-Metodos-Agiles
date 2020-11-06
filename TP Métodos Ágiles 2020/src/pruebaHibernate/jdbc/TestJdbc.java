package pruebaHibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL="jdbc:mysql://localhost:3306/prueba?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "Mati";
		String pass = "SQLPass";
		try {
			System.out.println("Connecting to DB: "+jdbcURL );
			Connection myCon=DriverManager.getConnection(jdbcURL,user,pass);
		
			System.out.println("Connected successfully");
		
		}catch(Exception exc){
			exc.printStackTrace();
		}
			
	}

}
