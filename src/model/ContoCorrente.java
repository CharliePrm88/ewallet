package model;

import java.util.Date;

public class ContoCorrente {
	private int iban,idCliente;
	private float saldo;
	private Date data_creazione;
	
	public ContoCorrente() {
		
	}
	
	public ContoCorrente(int iban, int idCliente, float saldo, Date data_creazione) {
		this.iban = iban;
		this.idCliente = idCliente;
		this.saldo = saldo;
		this.data_creazione = data_creazione;
	}
	public int getIban() {
		return iban;
	}
	public void setIban(int iban) {
		this.iban = iban;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idcliente) {
		this.idCliente = idcliente;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Date getData_creazione() {
		return data_creazione;
	}
	public void setData_creazione(Date data_creazione) {
		this.data_creazione = data_creazione;
	}
	
}
