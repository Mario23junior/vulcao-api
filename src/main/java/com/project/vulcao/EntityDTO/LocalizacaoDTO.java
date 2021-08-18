package com.project.vulcao.EntityDTO;

public class LocalizacaoDTO {
   
	private String continente;
	private String pais;
	private Double metros;
	private Double pes;
	private String cooordenadas;
	
	 
	
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Double getMetros() {
		return metros;
	}
	public void setMetros(Double metros) {
		this.metros = metros;
	}
	public Double getPes() {
		return pes;
	}
	public void setPes(Double pes) {
		this.pes = pes;
	}
	public String getCooordenadas() {
		return cooordenadas;
	}
	public void setCooordenadas(String cooordenadas) {
		this.cooordenadas = cooordenadas;
	}
}
