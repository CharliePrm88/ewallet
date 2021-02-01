package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ContoCorrente;

public class ContoCorrenteDao {
	
	public void inserisciContoCorrente(ContoCorrente c) throws SQLException, NamingException {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/banca");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String updateTableSQL = "INSERT INTO contocorrente(iban, idcliente,saldo,data_creazione) VALUES(?,?,?,?)";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, c.getIban());
		cmd.setInt(2, c.getIdCliente());
		cmd.setFloat(3, c.getSaldo());
		java.sql.Date d = new Date(c.getData_creazione().getTime());
		cmd.setDate(4, d);
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
		dbConnection.close();
	}
	
	public void updateContoCorrente(ContoCorrente c) throws SQLException, NamingException {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/banca");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String updateTableSQL = "UPDATE contocorrente SET iban=?, data_creazione=?, saldo=? WHERE idcliente=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, c.getIban());
		java.sql.Date d = new Date(c.getData_creazione().getTime());
		cmd.setDate(2, d);
		cmd.setFloat(3, c.getSaldo());
		cmd.setInt(4, c.getIdCliente());
		// execute update SQL stetement
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
		dbConnection.close();
	}
	
	public ContoCorrente ritornaContoCorrente(int idCliente) throws SQLException, NamingException {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/banca");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		ContoCorrente nuovo = null;
		String query = "SELECT * FROM contocorrente WHERE idcliente=?";
		cmd = dbConnection.prepareStatement(query);
		cmd.setInt(1, idCliente);
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		System.out.print(res);
		if(esci) {	
			nuovo = new ContoCorrente(res.getInt("iban"),res.getInt("idcliente"),res.getFloat("saldo"),res.getDate("data_creazione"));
		}else {
			java.sql.Date s = new java.sql.Date(0);
			nuovo = new ContoCorrente(0,0,0,s);
		}	
		cmd.close();
		dbConnection.close();
	return nuovo;
	}
	
	public List<ContoCorrente> ritornaListaContoCorrente() throws SQLException, NamingException{
		DataSource ds = (DataSource) new InitialContext().lookup("java:/banca");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		List<ContoCorrente> l1 = new ArrayList<>();
		String query = "SELECT * FROM contocorrente";
		cmd = dbConnection.prepareStatement(query);
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			ContoCorrente nuovo = new ContoCorrente(res.getInt("iban"),res.getInt("idcliente"),res.getFloat("saldo"),res.getDate("data_creazione"));
			l1.add(nuovo);
			esci = res.next();
		}
			cmd.close();
			dbConnection.close();
		return l1;
	}
	
	public void cancellaContoCorrente(ContoCorrente c) throws SQLException, NamingException {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/banca");
		Connection dbConnection = ds.getConnection();		java.sql.PreparedStatement cmd = null;
		String updateTableSQL = "DELETE FROM contocorrente WHERE iban=?";
		cmd = dbConnection.prepareStatement(updateTableSQL);
		cmd.setInt(1, c.getIban());
		cmd.executeUpdate();
		System.out.println("Record is updated to DBUSER table!");
		cmd.close();
		dbConnection.close();
	}
}

