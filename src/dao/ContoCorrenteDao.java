package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ContoCorrente;

public class ContoCorrenteDao {
	
	public boolean inserisciContoCorrente(ContoCorrente c) {
		boolean result = true;
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO contocorrente(iban, idcliente,saldo,data_creazione) VALUES(?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, c.getIban());
			cmd.setInt(2, c.getIdCliente());
			cmd.setFloat(3, c.getSaldo());
			cmd.setDate(4, c.getData_creazione());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			result = false;
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
		return result;
	}
	
	public boolean updateContoCorrente(ContoCorrente c) {
		boolean result = true;
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE contocorrente SET iban=?,saldo=? WHERE idcliente=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, c.getIban());
			cmd.setInt(2, c.getIdCliente());
			cmd.setFloat(3, c.getSaldo());
			cmd.setInt(4, c.getIdCliente());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			result=false;
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
		return result;
	}
	
	public ContoCorrente ritornaContoCorrente(int idCliente) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		ContoCorrente nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM contocorrente WHERE idcliente=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, idCliente);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			System.out.print(res);
			if(esci) {	
			nuovo = new ContoCorrente(res.getInt("iban"),res.getInt("idcliente"),res.getFloat("saldo"),res.getDate("data_creazione"));
			}else {
				nuovo = new ContoCorrente(0,0,0,null);
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
	
	public List<ContoCorrente> ritornaListaContoCorrente(){
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<ContoCorrente> l1 = new ArrayList<>();
		try {
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
				ContoCorrente nuovo = new ContoCorrente(res.getInt("iban"),res.getInt("idcliente"),res.getFloat("saldo"),res.getDate("data_creazione"));
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
	
	public boolean cancellaContoCorrente(ContoCorrente c) {
		Connection dbConnection = null;
		boolean ritorno;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/banca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM contocorrente WHERE iban=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, c.getIban());
			// execute update SQL statement
			cmd.executeUpdate();
			ritorno = true;
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			ritorno = false;
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
		return ritorno;
	}
}

