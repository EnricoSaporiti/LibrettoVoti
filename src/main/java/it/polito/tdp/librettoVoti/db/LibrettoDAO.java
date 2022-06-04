package it.polito.tdp.librettoVoti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.librettoVoti.model.Voto;

public class LibrettoDAO {

	public boolean creaVoto(Voto v) {
		
		try {
			Connection conn = DBConnect.getConnection();

			String insert =  "INSERT INTO voti (nome, punti ) VALUES ( ?, ? )";
			PreparedStatement ps = conn.prepareStatement(insert);
			
			ps.setString(1, v.getCorso() );
			ps.setInt(2, v.getPunteggio());

			int res = ps.executeUpdate();
			ps.close();

			conn.close();
			
			return (res==1);
			
		} catch (SQLException e) {
			System.out.println(e); 
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Voto> readAllVoto() {

		try {
			Connection conn = DBConnect.getConnection();

			String sql = "SELECT * FROM VOTI     ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Voto> libretto = new ArrayList<Voto>();
			
			while( rs.next()) {
				
				Voto v = new Voto(rs.getString(1), rs.getInt(2));
				libretto.add(v);
				System.out.println( "nome = " + rs.getString("nome") + " punteggio = " + rs.getInt("punti"));
			}
			
			rs.close();
			
			conn.close();
			
			return libretto;
			
		} catch (SQLException e) {
			System.out.println(e); 
			e.printStackTrace();
			return null;
		}

	}
	
//	public Voto readVotoByName(String nome) {
//		
//	}
	
}
