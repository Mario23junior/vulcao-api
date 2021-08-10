package com.project.vulcao.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String continente;
	private String pais;
	private Double metros;
	private Double pes;
	private String cooordenadas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
