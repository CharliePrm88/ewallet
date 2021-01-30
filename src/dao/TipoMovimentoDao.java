package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TipoMovimento;

public class TipoMovimentoDao {

	public void inserisciTipoMovimento(TipoMovimento t) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO tipomovimento(id_tipo_movimento, descrizione) VALUES(?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, t.getId_tipo_movimento());
			cmd.setString(2, t.getDescrizione());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
			}
	
	public void updateTipoMovimento(TipoMovimento t) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String updateTableSQL = "UPDATE tipomovimento SET descrizione=? WHERE id_tipo_movimento=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setString(1, t.getDescrizione());
		cmd.setInt(2, t.getId_tipo_movimento());
		// execute update SQL stetement
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
	}
	
	public TipoMovimento ritornaTipoMovimento(int id_tipo_movimento) throws SQLException, ClassNotFoundException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		TipoMovimento nuovo = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String query = "SELECT * FROM tipomovimento WHERE id_tipo_movimento=?";
		cmd = dbConnection.prepareStatement(query);
		cmd.setInt(1, id_tipo_movimento);
		// execute update SQL stetement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		System.out.print(res);
		if(esci) {	
			nuovo = new TipoMovimento(res.getInt("id_tipo_movimento"),res.getString("descrizione"));
		}else {
			nuovo = new TipoMovimento(0,null);
		}	
		cmd.close();
		dbConnection.close();
		return nuovo;
	}
	
	public List<TipoMovimento> ritornaListaTipoMovimento() throws ClassNotFoundException, SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<TipoMovimento> l1 = new ArrayList<>();
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String query = "SELECT * FROM tipomovimento";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL stetement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			TipoMovimento nuovo = new TipoMovimento(res.getInt("id_tipo_movimento"),res.getString("descrizione"));
			l1.add(nuovo);
			esci = res.next();
		}
		cmd.close();
		dbConnection.close();
		return l1;
	}
	
	public void cancellaTipoMovimento(TipoMovimento t) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Creiamo la stringa di connessione
		String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// Otteniamo una connessione con username e password
		dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
		String updateTableSQL = "DELETE FROM tipomovimento WHERE id_tipo_movimento=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, t.getId_tipo_movimento());
		// execute update SQL statement
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
		dbConnection.close();
	}


}
