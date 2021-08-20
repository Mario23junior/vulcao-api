package com.project.vulcao.EntityDTO;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LocalizacaoDTO {
   
	@Length(max = 5000, min = 2)
 	@NotNull(message = "continente")
	private String continente;
	
	@Length(max = 5000, min = 3)
 	@NotNull(message = "pais")
	private String pais;
	
  	@NotNull(message = "metros")
	private Double metros;
	
	private Double pes;
	
	@Length(max = 6000, min = 3)
 	@NotNull(message = "cooordenadas")
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
