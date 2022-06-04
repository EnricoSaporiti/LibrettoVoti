package it.polito.tdp.librettoVoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=root" ;
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println("Errore di connessione");
			e.printStackTrace();
			return null;
		}

		
	}

}
