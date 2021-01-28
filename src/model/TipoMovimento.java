package model;

public class TipoMovimento {
	private int id_tipo_movimento;
	private String descrizione;
	
	public TipoMovimento() {}
	
	public TipoMovimento(int id_tipo_movimento, String descrizione) {
		this.id_tipo_movimento = id_tipo_movimento;
		this.descrizione = descrizione;
	}
	public int getId_tipo_movimento() {
		return id_tipo_movimento;
	}
	public void setId_tipo_movimento(int id_tipo_movimento) {
		this.id_tipo_movimento = id_tipo_movimento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
