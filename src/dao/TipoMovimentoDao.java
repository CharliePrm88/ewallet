package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TipoMovimento;

public class TipoMovimentoDao {

	public boolean inserisciTipoMovimento(TipoMovimento t) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		boolean risultato;
		try {
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
			risultato = true;
		} catch (Exception e) {
			e.printStackTrace();
			risultato = false;
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return risultato;
	}
	
	public boolean updateTipoMovimento(TipoMovimento t) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		boolean risultato;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE tipomovimento SET descrizione=? WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, t.getDescrizione());
			cmd.setInt(2, t.getId_tipo_movimento());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			risultato = true;
		} catch (Exception e) {
			e.printStackTrace();
			risultato = false;
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return risultato;
	}
	
	public TipoMovimento ritornaTipoMovimento(int id_tipo_movimento) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		TipoMovimento nuovo = null;
		try {
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
			nuovo = new TipoMovimento(res.getInt("id_tipo_movimento"),res.getString("id_tipo_movimento"));
			}else {
				nuovo = new TipoMovimento(0,null);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		return nuovo;
		
	}
	
	public List<TipoMovimento> ritornaListaTipoMovimento(){
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<TipoMovimento> l1 = new ArrayList<>();
		try {
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
				TipoMovimento nuovo = new TipoMovimento(res.getInt("id_tipo_movimento"),res.getString("id_tipo_movimento"));
				l1.add(nuovo);
				esci = res.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		return l1;
	}
	
	public boolean cancellaTipoMovimento(TipoMovimento t) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		boolean risultato;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM tipomovimento WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, t.getId_tipo_movimento());
			// execute update SQL statement
			cmd.executeUpdate();
			risultato = true;
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			e.printStackTrace();
			risultato = false;
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return risultato;
	}


}
