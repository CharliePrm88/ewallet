package model;

import java.util.Date;

public class Movimenti {
	private int id,iban,id_tipo_movimento;
	private float importo;
	Date data_movimento;
	
	public Movimenti() {}
	
	public Movimenti(int id, int iban, int id_tipo_movimento, float importo, Date data_movimento) {
		this.id = id;
		this.iban = iban;
		this.id_tipo_movimento = id_tipo_movimento;
		this.importo = importo;
		this.data_movimento = data_movimento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIban() {
		return iban;
	}
	public void setIban(int iban) {
		this.iban = iban;
	}
	public int getId_tipo_movimento() {
		return id_tipo_movimento;
	}
	public void setId_tipo_movimento(int id_tipo_movimento) {
		this.id_tipo_movimento = id_tipo_movimento;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public Date getData_movimento() {
		return data_movimento;
	}
	public void setData_movimento(Date data_movimento) {
		this.data_movimento = data_movimento;
	}
}
