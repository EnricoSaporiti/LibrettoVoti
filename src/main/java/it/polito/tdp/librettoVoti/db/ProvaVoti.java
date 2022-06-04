package it.polito.tdp.librettoVoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProvaVoti {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String nome = "Fisica I";
		int punti = 30;
		String url = "jdbc:mysql://localhost:3306/libretto?user=root&password=root" ;
		try {
			Connection conn = DriverManager.getConnection(url);
			
			String insert =  "INSERT INTO voti (nome, punti ) VALUES ( ?, ? )";
			PreparedStatement ps = conn.prepareStatement(insert);
			
			ps.setString(1, nome );
			ps.setInt(2, punti);

			int res = ps.executeUpdate();
			ps.close();
			
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM VOTI     ";
			ResultSet rs = st.executeQuery(sql);
			
			while( rs.next()) {
				System.out.println( "nome = " + rs.getString("nome") + " punteggio = " + rs.getInt("punti"));
			}
			
			conn.close();
			
		} catch (SQLException e) {
				
			e.printStackTrace();
		}
		
		System.out.println("finito");

	}

}
