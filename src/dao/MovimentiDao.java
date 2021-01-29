package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.Movimenti;

public class MovimentiDao {
	public void inserisciMovimenti(Movimenti m) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO movimenti(id, iban,importo,data_movimento, id_tipo_movimento) VALUES(?,?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, m.getId());
			cmd.setInt(2, m.getIban());
			cmd.setFloat(3, m.getImporto());
			java.sql.Date d = new Date(m.getData_movimento().getTime());
			cmd.setDate(4, d);
			cmd.setInt(5, m.getId_tipo_movimento());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
	}
	
	public void updateMovimenti(Movimenti m) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String updateTableSQL = "UPDATE movimenti SET iban=?,importo=?,data_movimento=?,id_tipo_movimento=? WHERE id=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, m.getIban());
		cmd.setFloat(2, m.getImporto());
		java.sql.Date d = new Date(m.getData_movimento().getTime());
		cmd.setDate(3, d);
		cmd.setInt(4, m.getId_tipo_movimento());
		cmd.setInt(5, m.getId());
		// execute update SQL stetement
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
	    dbConnection.close();
	}
	
	public Movimenti ritornaMovimenti(int id) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Movimenti nuovo = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String query = "SELECT * FROM movimenti WHERE id=?";
		cmd = dbConnection.prepareStatement(query);
		cmd.setInt(1, id);
		// execute update SQL stetement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		System.out.print(res);
		if(esci) {	
		nuovo = new Movimenti(res.getInt("id"),res.getInt("iban"),res.getInt("id_tipo_movimento"),res.getFloat("importo"),res.getDate("data_movimento"));
		}else {
			nuovo = new Movimenti(0,0,0,0,null);
		}
		cmd.close();
		dbConnection.close();
		return nuovo;
		
	}
	
	public List<Movimenti> ritornaListaMovimenti() throws SQLException, ClassNotFoundException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Movimenti> l1 = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String query = "SELECT * FROM contocorrente";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL stetement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			Movimenti nuovo = new Movimenti(res.getInt("id"),res.getInt("iban"),res.getInt("id_tipo_movimento"),res.getFloat("importo"),res.getDate("data_movimento"));
			l1.add(nuovo);
			esci = res.next();
			}
		cmd.close();
		dbConnection.close();
		return l1;
	}
	
	public void cancellaMovimenti(Movimenti m) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String updateTableSQL = "DELETE FROM movimenti WHERE id=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, m.getId());
		// execute update SQL statement
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
		dbConnection.close();
	}
}
